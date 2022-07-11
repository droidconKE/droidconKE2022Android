pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
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