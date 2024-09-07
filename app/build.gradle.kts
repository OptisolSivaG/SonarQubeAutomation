plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.sonarqubeautomation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sonarqubeautomation"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
        versionNameSuffix = ".1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val appName = "SonarQubeAutomation"
        manifestPlaceholders["appName"] = appName
        versionCode = (versionName + versionNameSuffix).replace(".", "").toInt()
        val apkName = "${appName}_$versionName$versionNameSuffix($versionCode).apk"

        // change app name block below
        buildOutputs.all {
            val variantOutputImpl = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            variantOutputImpl.outputFileName =  apkName
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

/*    flavorDimensions += "usertype"

    productFlavors {
        create("free") {
            dimension = "usertype"
            val appName = "SonarQubeAutomation"
            manifestPlaceholders["appName"] = appName
            applicationIdSuffix = ".demo"
            versionName = "0.0.1"
            versionNameSuffix = ".1"
            versionCode = (versionName + versionNameSuffix).replace(".", "").toInt()
            val apkName = "${appName}_$versionName$versionNameSuffix($versionCode).apk"

            // change app name block below
            buildOutputs.all {
                val variantOutputImpl = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
                variantOutputImpl.outputFileName =  apkName
            }
        }
    }*/

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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
}