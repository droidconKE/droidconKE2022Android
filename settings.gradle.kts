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
rootProject.name = "DroidconKE2022"

mapOf(
    "app" to "app"
).forEach { (projectName, projectPath) ->
    include(":$projectName")
    project(":$projectName").projectDir = File(projectPath)
}
