This is an UNOFFICIAL fork of [ClayTech](https://github.com/ClayCoffee/ClayTech) as a fixed version of [ClayTech](https://github.com/ClayCoffee/ClayTech)

# ClayTech

A slimefun addon for Minecraft.

## 前置 / Requirements

- Spigot / Paper 1.20.x
- [Slimefun4](https://github.com/SlimefunGuguProject/Slimefun4)（硬依赖，缺失时 Bukkit 会拒绝启用本插件）
- Java 20+ 运行时

## 安装 / Installation

1. 将 `ClayTech-<version>.jar` 放入服务端的 `plugins/` 目录
2. 确认服务端已安装 Slimefun4
3. 重启服务端

## 命令 / Commands

| 命令 | 权限 | 说明 |
| --- | --- | --- |
| `/claytech` | `claytech.basic` | 主命令，自动补全可用子命令 |
| `/claytech checkupdate` | `claytech.checkupdate` | 检查更新 |

`claytech.bypasstpcheck` 用于绕过星球传送检查（默认仅 OP）。

# 温馨提醒 / Tips

You can join the official discord server here: [Click this](https://discord.gg/sbNKCCs)

# 支持语言 / Supported Languages

* 简体中文 zh-CN
* 繁體中文 zh-TW
* 日本語 ja
* Polski pl-PL
* Français fr
* English(UK) en-GB
* English(US) en-US (default)

# 支持版本 / Supported Minecraft Server Version

* Spigot / PaperSpigot 1.20.x

# 构建 / Build

编译目标是 Java 20 字节码，构建用仓库自带的 Gradle wrapper，本机不需要预装 Gradle：

```bash
./gradlew clean build
```

产物在 `build/libs/ClayTech-<version>.jar`（shadow 插件打的 fat jar）。

- 版本号只改 `gradle.properties` 的 `version=`；`plugin.yml` 里的 `${version}` 由 `processResources` 在构建期注入。
- 依赖坐标集中在 `gradle/libs.versions.toml`，`build.gradle.kts` 只引用 `libs.xxx`。
- `lib/` 下的本地 JAR（WorldBorder、ClayAPI）随仓库走，没有发布到任何远程仓库。

# 自动化 / Automation

| Workflow | 触发条件 | 作用 |
| --- | --- | --- |
| `build.yml` | push / PR 到 `master` | 编译并上传 jar 产物 |
| `test-compatibility.yml` | push / PR，也可手动指定版本列表 | 起真实 Paper 服务端，确认插件能正常 Enabling |
| `release.yml` | `gradle.properties` 的 version 变更 | 打 tag 并创建 GitHub Release |

# 反馈 / Issues

问题请提到 [Issues](https://github.com/balugaq/ClayTech/issues)。
