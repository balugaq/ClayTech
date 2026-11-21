plugins {
    java
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.paper)
}

group = "cn.claycoffee"
version = providers.gradleProperty("version").get()

// 配置期取好，避免 processResources 在执行期碰 Task.project（Gradle 10 会直接报错）
val pluginVersion = version.toString()

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    // 必须显式声明：ClayAPI-1.0.4.jar 内嵌了 2013 年的 NotNull（无 TYPE_USE），
    // 一旦它抢在 24.0.1 前面被 javac 解析，`ItemStack @NotNull []` 全会报「批注在此类型上下文中不适用」
    compileOnly("org.jetbrains:annotations:24.0.1")

    compileOnly(libs.paper.api)
    compileOnly(libs.slimefun4)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    // WorldBorder 没有可用的远程坐标，由 lib/ 下的本地 JAR 提供。
    // 注意：不要把 ClayAPI-1.0.4.jar 放进 classpath——它内嵌了 2013 年的 org.jetbrains.annotations
    // （@Target 不含 TYPE_USE），会让所有 `ItemStack @NotNull []` 编译报错；当前源码 0 处引用它。
    // 将来真要调 ClayAPI 的类，请先重新打一个不含内嵌注解的包。
    compileOnly(fileTree(mapOf("dir" to "lib", "include" to listOf("WorldBorder*.jar", "org.eclipse.jdt.annotation*.jar"))))
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        // 保持与 pom.xml 的 java.version=20 一致；CI 用更高的 JDK 编译，字节码仍是 20
        options.release = 20
    }

    // plugin.yml 里的 ${version} 由这里注入，别改回 Maven 的 ${project.version}
    processResources {
        filesMatching("plugin.yml") {
            expand(mapOf("version" to pluginVersion))
        }
    }

    shadowJar {
        archiveBaseName.set("ClayTech")
        archiveVersion.set(project.version.toString())
        archiveClassifier.set("")

        exclude("META-INF/*")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    build {
        dependsOn(shadowJar)
    }

    runServer {
        dependsOn(shadowJar)
        val runDir = file(providers.gradleProperty("server.run.dir").orElse("run"))
        // 用约定路径取产物：copy {} 块内的 receiver 是 CopySpec，拿不到 tasks.shadowJar
        val pluginJar = layout.buildDirectory.file("libs/ClayTech-$version.jar")
        runDirectory.set(runDir)
        minecraftVersion("1.20.1")

        doFirst {
            runDir.resolve("eula.txt").writeText("eula=true")
            val pluginsDir = runDir.resolve("plugins").apply { mkdirs() }
            copy {
                from(pluginJar)
                into(pluginsDir)
            }
        }
    }
}

defaultTasks("clean", "build")
