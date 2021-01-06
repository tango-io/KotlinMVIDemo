// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    /*ext.kotlin_version = "1.3.72"*/
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.gradle_tools)
        classpath(Dependencies.gradle_kotlin_plugin)

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