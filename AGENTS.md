# AGENTS.md — ClayTech

给 AI 代理的工作指南。改动前先读这份文件，能少踩很多坑。

## 项目是什么

ClayTech 是一个 **Slimefun 附属插件**（Minecraft，Spigot/Paper 1.20.x），
主题是太空科技：星球（月球/火星/小行星带）、火箭、宇航服、太空食物饮料、
元素提取、机械等。

本仓库是 [ClayCoffee/ClayTech](https://github.com/ClayCoffee/ClayTech) 的
**非官方修复 fork**（`ClayTech-Fixed`，版本 `UNOFFICIAL-6`），主要维护者是 balugaq。

## 技术栈与构建

- **Java 20**、Gradle（Kotlin DSL）、Lombok
- 依赖均为 `compileOnly`，勿改成 `implementation`：`paper-api 1.20.1`、`Slimefun4 2024.3`（jitpack）。坐标全在 `gradle/libs.versions.toml`，`build.gradle.kts` 只用 `libs.xxx` 引用。
- **本地 JAR**：`WorldBorder`、`ClayAPI-1.0.4` 没有可用的远程坐标，由 `lib/*.jar` 提供（`compileOnly(fileTree("lib"))`）。别删 lib，`.gitignore` 里用 `!lib/*.jar` 白名单保住它们。
- 构建：`./gradlew clean build`（shadow 插件把 fat jar 打到 `build/libs/`）
- 版本号在 `gradle.properties` 的 `version=`；`plugin.yml` 里的 `${version}` 由 `processResources` 注入。改版本只动 `gradle.properties`，`release.yml` 也从那里读。

## 代码结构

```
src/main/java/cn/claycoffee/clayTech/
├── ClayTech.java            # 主类，JavaPlugin + SlimefunAddon，星球列表、配置读取、太空伤害计时器
├── ClayTechItems.java       # 物品注册入口
├── ClayTechMachineRecipes.java # 机器配方注册
├── ClayTechRecipeType.java  # 自定义配方类型
├── ClayTechCommands.java    # /claytech 命令
├── ClayTechUpdater.java     # 更新检查（分支见 ClayTechBranch）
├── api/                     # 供其他开发者使用的公开 API
│   ├── ClayTechManager.java #   事件总线：注册机器/事件
│   ├── events/              #   自定义 Bukkit 事件（PlayerEatEvent、RocketLandEvent 等）
│   ├── objects/             #   Planet、Language 等数据类
│   └── slimefun/            #   AbstractMachine、ACraftingTable 等抽象基类
├── core/
│   ├── listeners/           # Bukkit 监听器（火箭发射、气闸、传送带、武器……）
│   ├── managers/            # ConfigManager、ListenerManager
│   ├── services/            # LocalizationService（多语言）
│   └── worlds/              # 自定义世界生成：Earth / Moon / Mars / AsteroidBelt + Populator
├── implementation/
│   ├── items/               # 物品分组注册（按类别一个类：Foods、Drinks、Rockets……）
│   ├── machines/            # 具体机器实现
│   └── resources/           # 燃料等资源
└── utils/                   # Lang、PlanetUtil、RocketUtil 等工具类
```

资源：

```
src/main/resources/
├── plugin.yml     # 名称 ClayTech-Fixed，depend: Slimefun，softdepend: WorldBorder
├── config.yml
├── planets.yml / planetsdata.yml   # 星球配置
└── lang/          # 7 种语言：en-US(默认)、zh-CN、zh-TW、ja、fr、pl-PL、en-GB
```

## 开发约定

- **包结构按上面分层**：新机器放 `implementation/machines`，新物品组放
  `implementation/items` 并在 `ClayTechItems` / 主类里注册；改 API 面时
  保持 `api/` 与 `implementation/` 的边界，别让 implementation 反向泄漏进 api。
- **新机器**优先继承 `api/slimefun` 下的抽象基类（`AbstractMachine`、
  `ACraftingTable` 等），而不是裸写 Slimefun 类。
- **所有面向玩家的文本走 lang 文件**（`utils/Lang` + `LocalizationService`），
  不要硬编码字符串；加 key 时 7 个语言文件都要补。
- 事件类如有新交互，考虑加到 `api/events` 供下游监听。
- Lombok 可用；`@SuppressWarnings("deprecation")` 已在主类使用，新代码尽量
  用非弃用 API，实在要用的注明原因。

## 已知坑

- `target/` 是 Maven 时代的遗留产物，`build/` 才是现在的 Gradle 输出；两者都别当源码参考，以 `src/` 为准。
- 主类里有 `.idea/` 残留在 `api/` 包目录下（历史遗留），无关构建，别动也别学。
- `harmInSpace` 这类 BukkitRunnable 是静态的，重载插件时注意重复注册问题。
- `plugin.yml` 的 `version` 必须保持 `${version}` 占位符（Gradle 的 `expand` 注入）；写成 `${project.version}` 会在 jar 里留下字面量，Bukkit 加载失败。
- Slimefun 是硬依赖，本地起服测试需要装 Slimefun4（`./gradlew runServer` 会自动把产物丢进 `run/plugins`，Slimefun 自己放）。
- **别把 `lib/ClayAPI-1.0.4.jar` 加进 compile classpath**：它内嵌 2013 年的 `org.jetbrains.annotations`，会让所有 `ItemStack @NotNull []` 报「批注在此类型上下文中不适用」。

## 验收

- 改完跑 `./gradlew clean build`，编译零错误即通过静态验收。
- 无测试框架；不要自行引入测试框架除非主人要求。
