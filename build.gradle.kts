buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.23.8"
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}