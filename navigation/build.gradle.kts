import java.io.ByteArrayOutputStream

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
        singleVariant("release") {
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
        create<MavenPublication>("release") {
            groupId = "com.daniel.budgetplanner"
            artifactId = "dashboard-navigation"
            version = getVersionTag()

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("Budget Dashboard Navigation")
            }
        }
    }
}

fun getVersionTag(): String {
    val stdout = ByteArrayOutputStream()
    try {
        exec {
            commandLine("git", "describe", "--tags", "--abbrev=0")
            standardOutput = stdout
        }
        val version = stdout.toString().trim()
        return if (version.startsWith("v")) version.substring(1) else version
    } catch (e: Exception) {
        return "1.0.0"
    }
}

dependencies {
    /* Kotlin */
    implementation(libs.bundles.kotlin)

    /* Base */
    implementation(libs.base)
}