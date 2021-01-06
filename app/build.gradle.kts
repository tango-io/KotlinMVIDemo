plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(App.compileSdk)
    buildToolsVersion = App.buildTools

    defaultConfig {
        applicationId = App.applicationId
        minSdkVersion(App.minSdk)
        targetSdkVersion(App.targetSdk)
        versionCode = App.versionCode
        versionName = App.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
    implementation(Dependencies.kotlin_stlib)
    implementation(Dependencies.androidx_core)
    implementation(Dependencies.androidx_compat)
    implementation(Dependencies.google_material)
    testImplementation(TestDeps.junit)
    androidTestImplementation(AndroidTestDeps.android_junit)
    androidTestImplementation(AndroidTestDeps.android_espresso)
}