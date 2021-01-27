object Dependencies {
    val gradle_tools = "com.android.tools.build:gradle:${Versions.gradle_tools}"
    val gradle_kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    val kotlin_stlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val androidx_compat = "androidx.appcompat:appcompat:${Versions.androidx_compat}"
    val google_material = "com.google.android.material:material:${Versions.google_material}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide_version}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    val kotlin_coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"

    val moshi = "com.squareup.moshi:moshi:${Versions.moshi_version}"
    val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi_version}"
    val moshi_adapter = "com.squareup.moshi:moshi-adapters:${Versions.moshi_version}"

}

object TestDeps {
    val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestDeps {
    val android_junit = "androidx.test.ext:junit:${Versions.android_junit}"
    val android_espresso = "androidx.test.espresso:espresso-core:${Versions.android_espresso}"
}