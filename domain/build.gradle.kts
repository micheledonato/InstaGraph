import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

dependencies {
    val coroutinesVersion: String by project

    api(kotlin("stdlib-jdk8"))

    api("org.jetbrains.kotlinx", "kotlinx-coroutines-android", coroutinesVersion)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}