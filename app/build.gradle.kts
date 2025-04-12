plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.geriabdulmalik.moneymanagement"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.geriabdulmalik.moneymanagement"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // 🔹 Android Core & Lifecycle
    implementation("androidx.core:core-ktx:1.9.0") // KTX Extension untuk Kotlin
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4") // Lifecycle runtime terbaru
    implementation("androidx.activity:activity-compose:1.9.0") // Support Activity dengan Jetpack Compose

    // 🔹 Jetpack Compose Core
    implementation(platform("androidx.compose:compose-bom:2023.03.00")) // BOM untuk versi Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3-android:1.2.0-rc01")
    implementation("androidx.compose.animation:animation:1.6.0")
    implementation("com.google.accompanist:accompanist-placeholder-material:0.33.2-alpha")

    // 🔹 Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6") // Navigasi antar layar di Compose

    // 🔹 Coroutines untuk Asynchronous Programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // 🔹 Dependency Injection (Hilt)
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // 🔹 Lifecycle ViewModel (MVVM)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    // 🔹 Networking dengan Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp untuk RequestBody dan MediaType
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    //shared preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // 🔹 Testing Dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // 🔄 Update versi
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // 🔹 Debugging & UI Tools
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}