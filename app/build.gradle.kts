plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")

    kotlin("plugin.serialization") version "2.0.21"

    id("kotlin-parcelize")

    id("org.jetbrains.kotlin.kapt")

}

android {
    namespace = "com.example.todo_xml"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.todo_xml"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val room_version = "2.7.2"
    implementation("androidx.room:room-runtime:$room_version")
    // Replace kapt with ksp for the Room compiler
    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    val nav_version = "2.9.3"
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    val lifecycle_version = "2.8.2"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")


}