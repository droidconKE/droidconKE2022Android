import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidConfig : Plugin<Project> {
    override fun apply(target: Project){
        with(target) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")

        }
    }
}