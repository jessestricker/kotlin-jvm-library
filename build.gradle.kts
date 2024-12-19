@file:Suppress("UnstableApiUsage")

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
    }
}

testing {
    suites.named("test", JvmTestSuite::class) {
        useJUnitJupiter(libs.versions.junit.jupiter)
    }
}
