import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    java
    alias(libs.plugins.pluginYml)
}

group = "org.dynmap"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    maven { url = uri("https://repo.papermc.io/repo/maven-public/") }
    maven { url = uri("https://jitpack.io/") }
    maven { url = uri("https://repo.mikeprimm.com/") }
    mavenLocal()
}

dependencies {
    compileOnly(libs.paperApi)
    compileOnly(libs.griefPrevention)
    compileOnly(libs.dynmapCore)
    compileOnly(libs.dynmapApi)
}

paper {
    main = "org.dynmap.griefprevention.DynmapGriefPreventionPlugin"
    apiVersion = libs.versions.paperApi.get().replace(Regex("\\-R\\d.\\d-SNAPSHOT"), "")
    authors = listOf("mikeprimm", "stumper66", "Jim (AnEnragedPigeon)")
    description = "Show GriefPrevention claims on dynmap"

    serverDependencies {
        register("dynmap") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
        register("GriefPrevention") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }
}
