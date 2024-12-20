@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.kotlin.jvm)
    `maven-publish`

    alias(libs.plugins.detekt)
    alias(libs.plugins.kover)
    alias(libs.plugins.ktfmt)
}

group = "org.example"

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

java {
    withSourcesJar()
}

testing {
    suites.named<JvmTestSuite>("test") {
        useJUnitJupiter(libs.versions.junit.jupiter)
        dependencies {
            implementation(libs.kotest.assertions.core)
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_REPOSITORY")}")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("main") {
            from(components["java"])
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
