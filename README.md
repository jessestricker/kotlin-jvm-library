# kotlin-jvm-library

A template repository for Kotlin/JVM library projects.

## Usage

After creating a new repository from this template, do the following:

- Set `rootProject.name` in [settings.gradle.kts](settings.gradle.kts).
- Generate a new Gradle encryption key with `openssl rand -base64 16` and set is
  as the GitHub action secret `GRADLE_ENCRYPTION_KEY`.
