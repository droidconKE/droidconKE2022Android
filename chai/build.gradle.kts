plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.android.coreKtx)
    implementation(libs.android.appCompat)
    implementation(libs.android.material)
    implementation(libs.bundles.compose)
    implementation(libs.lifecycle.runtimeKtx)
    implementation(libs.timber)
    implementation(libs.android.hilt)

    androidTestImplementation(libs.android.test.junit4)
    androidTestImplementation(libs.android.test.espresso)
    androidTestImplementation(libs.compose.ui.test.junit)

    testImplementation(libs.test.junit4)
    testImplementation(libs.test.robolectric)
    testImplementation(libs.compose.ui.test.junit)
    testImplementation(libs.android.test.espresso)
}