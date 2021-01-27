// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.21")
    /*ext.kotlin_version = "1.3.72"*/
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.gradle_tools)
        classpath(Dependencies.gradle_kotlin_plugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}