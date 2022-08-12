pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

mapOf(
    "app" to "app",
    "data" to "data",
    "domain" to "domain",
    "presentation" to "presentation"
).forEach { (projectName, projectPath) ->
    include(":$projectName")
    project(":$projectName").projectDir = File(projectPath)
}

rootProject.name = "DroidconKE2022"
include(":chai")
include(":chaidemo")
