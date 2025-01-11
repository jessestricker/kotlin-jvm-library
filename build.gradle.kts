@file:Suppress("UnstableApiUsage")

import java.util.jar.Attributes.Name as AttributeName

plugins {
    alias(libs.plugins.kotlin.jvm)
    `maven-publish`

    alias(libs.plugins.binaryCompatibilityValidator)
    alias(libs.plugins.detekt)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kover)
    alias(libs.plugins.ktfmt)
}

group = "org.example"

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

tasks.jar {
    manifest {
        attributes(
            AttributeName.IMPLEMENTATION_TITLE.toString() to "${project.group}.${project.name}",
            AttributeName.IMPLEMENTATION_VERSION.toString() to project.version,
        )
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

dokka {
    dokkaSourceSets.main {
        includes.from("src/main/kotlin/Module.md")
    }
}

ktfmt {
    kotlinLangStyle()
}
