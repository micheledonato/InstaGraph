// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val gradleVersion: String by project
    val kotlinVersion: String by project
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build", "gradle", gradleVersion)
        classpath("org.jetbrains.kotlin", "kotlin-gradle-plugin", kotlinVersion)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}