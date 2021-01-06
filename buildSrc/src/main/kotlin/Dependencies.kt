object Dependencies {
    val gradle_tools = "com.android.tools.build:gradle:${Versions.gradle_tools}"
    val gradle_kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    val kotlin_stlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val androidx_compat = "androidx.appcompat:appcompat:${Versions.androidx_compat}"
    val google_material = "com.google.android.material:material:${Versions.google_material}"
}

object TestDeps {
    val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestDeps {
    val android_junit = "androidx.test.ext:junit:${Versions.android_junit}"
    val android_espresso = "androidx.test.espresso:espresso-core:${Versions.android_espresso}"
}