import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
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
            buildConfigField("String", "API_KEY", "\"${getApiKey()}\"")
        }

        getByName("debug") {
            buildConfigField("String", "API_KEY", "\"${getApiKey()}\"")
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

    implementation(Dependencies.kotlin_coroutines)

    implementation(Dependencies.androidx_core)
    implementation(Dependencies.androidx_compat)
    implementation(Dependencies.google_material)
    implementation(Dependencies.glide)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_gson)
    implementation(Dependencies.moshi_converter)

    implementation(Dependencies.moshi)
    implementation(Dependencies.moshi_adapter)
    kapt(Dependencies.moshi_codegen)

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")


    annotationProcessor(Dependencies.glide_compiler)
    testImplementation(TestDeps.junit)
    androidTestImplementation(AndroidTestDeps.android_junit)
    androidTestImplementation(AndroidTestDeps.android_espresso)
}

fun getApiKey(): String {
    val keysFile = file("keys.properties")
    val keysProperties = Properties()
    keysProperties.load(FileInputStream(keysFile))
    return keysProperties.getProperty("API_KEY")
}