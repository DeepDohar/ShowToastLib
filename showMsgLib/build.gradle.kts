plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")

}

android {
    namespace = "com.example.showmsglib"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

}
 afterEvaluate {
     publishing {
         publications {
             register<MavenPublication>("release") {
                 groupId = "com.github.DeepDohar"
                 artifactId = "ShowToastLib"
                 version = "1.0.0"

                 afterEvaluate {
                     from(components["release"])
                 }
             }
         }
     }
 }