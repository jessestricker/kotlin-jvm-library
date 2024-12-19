@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()
    compilerOptions {
        extraWarnings = true
        progressiveMode = true

        jvmTarget = libs.versions.java.map { JvmTarget.fromTarget(it) }
        freeCompilerArgs.add(libs.versions.java.map { "-Xjdk-release=$it" })
    }
}

tasks.withType<JavaCompile> {
    options.release = libs.versions.java.map { it.toInt() }
}

testing {
    suites.named<JvmTestSuite>("test") {
        useJUnitJupiter(libs.versions.junit.jupiter)
    }
}
