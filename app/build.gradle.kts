import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    val compileSdkVersion: String by project
    val buildToolsVersion: String by project
    val minSdkVersion: String by project

    val appName: String by project
    val appId: String by project

    val versionMajor: String by project
    val versionMinor: String by project
    val versionPatch: String by project
    val buildNumber: String by project

    val computeVersionCode =
        (versionMajor.toInt() * 1000000) + (versionMinor.toInt() * 100000) + (versionPatch.toInt() * 10000) + buildNumber.toInt()
    val computeVersionName = String.format("%s.%s.%s", versionMajor, versionMinor, versionPatch)

    compileSdkVersion(compileSdkVersion.toInt())
    buildToolsVersion(buildToolsVersion)

    defaultConfig {
        applicationId = appId
        minSdkVersion(minSdkVersion)
        targetSdkVersion(compileSdkVersion)
        versionCode = computeVersionCode
        versionName = computeVersionName

        resValue("string", "app_name", appName)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val appcompatVersion: String by project
    val coreVersion: String by project
    val constraintlayoutVersion: String by project
    val recyclerviewVersion: String by project
    val lifecycleVersion: String by project
    val fragmentVersion: String by project
    val coroutinesVersion: String by project
    val koinVersion: String by project
    val retrofitVersion: String by project
    val gsonVersion: String by project
    val coilVersion: String by project

    implementation(project(":data"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(kotlin("stdlib-jdk8"))

    implementation("androidx.appcompat", "appcompat", appcompatVersion)
    implementation("androidx.core", "core-ktx", coreVersion)
    implementation("androidx.constraintlayout", "constraintlayout", constraintlayoutVersion)
    implementation("androidx.recyclerview", "recyclerview", recyclerviewVersion)
    implementation("androidx.lifecycle", "lifecycle-viewmodel-ktx", lifecycleVersion)
    implementation("androidx.lifecycle", "lifecycle-livedata-ktx", lifecycleVersion)
    implementation("androidx.fragment", "fragment", fragmentVersion)

    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-android", coroutinesVersion)

    implementation("org.koin", "koin-android", koinVersion)
    implementation("org.koin", "koin-android-viewmodel", koinVersion)

    implementation("com.squareup.retrofit2", "retrofit", retrofitVersion)
    implementation("com.squareup.retrofit2", "converter-gson", retrofitVersion)

    implementation("com.google.code.gson", "gson", gsonVersion)

    implementation("io.coil-kt", "coil", coilVersion)

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}