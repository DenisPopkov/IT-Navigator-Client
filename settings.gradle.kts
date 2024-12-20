@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("gradle-plugins")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ITNavigatorClient"
include(
    ":app",
    ":core:feature:data",
    ":core:feature:domain",
    ":core:feature:nav",
    ":core:feature:ui",
    ":core:feature:datastore",
    ":features:home:nav",
    ":features:home:ui",
    ":features:search:nav",
    ":features:search:ui",
    ":features:settings:nav",
    ":features:settings:ui",
    ":features:section:nav",
    ":features:section:ui",
    ":features:auth:nav",
    ":features:auth:ui",
    ":features:splash:nav",
    ":features:splash:ui",
    ":theme",
)
