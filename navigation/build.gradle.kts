plugins {
    id("kotlin-android")
    id("com.android.library")
    id("maven-publish")

    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.daniel.budgetplanner.dashboard.navigation"

    defaultConfig {
        minSdk = 26
        compileSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    publishing {
        singleVariant("debug") {
            withSourcesJar()
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }
}

publishing {
    publications {
        create<MavenPublication>("debug") {
            groupId = "com.daniel.budgetplanner"
            artifactId = "dashboard-navigation"
            version = "1.0.0"

            afterEvaluate {
                from(components["debug"])
            }

            pom {
                name.set("Budget Dashboard Navigation")
            }
        }
    }
}

dependencies {
    /* Kotlin */
    implementation(libs.bundles.kotlin)

    /* Base */
    implementation(libs.base)
}