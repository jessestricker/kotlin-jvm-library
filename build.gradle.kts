@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.kotlin.jvm)

    alias(libs.plugins.detekt)
    alias(libs.plugins.kover)
    alias(libs.plugins.ktfmt)
}

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()
    compilerOptions {
        extraWarnings = true
        progressiveMode = true
    }
    jvmToolchain {
        languageVersion = libs.versions.java.map { JavaLanguageVersion.of(it) }
    }
}

testing {
    suites.named<JvmTestSuite>("test") {
        useJUnitJupiter(libs.versions.junit.jupiter)
        dependencies {
            implementation(libs.kotest.assertions.core)
        }
    }
}

detekt {
    buildUponDefaultConfig = true
    config.setFrom(".config/detekt.yml")
}

ktfmt {
    kotlinLangStyle()
}
