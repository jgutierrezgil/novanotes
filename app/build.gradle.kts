plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.kapt") // Para Room - annotation processing
}

android {
    namespace = "com.novaprivacy.novanotes"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.novaprivacy.novanotes"
        minSdk = 26
        targetSdk = 35
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Usar la versión compatible con tu Kotlin y Compose
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Jetpack Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.7.5") // Usar la versión más reciente

    // Room Persistence Library
    implementation("androidx.room:room-runtime:2.6.1") // Usar la versión más reciente
    kapt("androidx.room:room-compiler:2.6.1") // annotationProcessor for Room
    implementation("androidx.room:room-ktx:2.6.1") // Kotlin extensions for Room

    // SQLCipher for Room
    implementation("net.zetetic:sqlcipher-android:4.5.3") // Usar la versión más reciente

    // Tink - Google's Crypto Library
    implementation("com.google.crypto.tink:tink-android:1.12.0") // Usar la versión más reciente

    // Argon2 - Password Hashing
    implementation("com.kosprov.jargon2:jargon2-api:1.9.0") // Usar la versión más reciente

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Usar la versión más reciente
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // Usar la versión más reciente

    // Material Design Icons
    implementation("androidx.compose.material:material-icons-extended:1.7.0") // Usar la versión más reciente

    // SplashScreen API (para pantallas de carga personalizadas)
    implementation("androidx.core:core-splashscreen:1.0.1") // Usar la versión más reciente

    // Para selector de idioma (ejemplo, puede ser simplificado inicialmente)
    implementation("androidx.core:core-ktx:1.12.0") // Usar la versión más reciente
    implementation("androidx.appcompat:appcompat:1.7.0-alpha03") // Usar la versión más reciente
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-alpha03") // Usar la versión más reciente


}