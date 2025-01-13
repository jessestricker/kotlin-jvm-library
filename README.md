# kotlin-jvm-library

A template repository for Kotlin/JVM library projects.

## Usage

After creating a new repository from this template, do the following:

- In the repository
  - Replace value of `rootProject.name` in
    [settings.gradle.kts](settings.gradle.kts).
  - Replace value of `group` in [build.gradle.kts](build.gradle.kts).
  - Rename package in [src/main/kotlin](src/main/kotlin) and
    [src/test/kotlin](src/test/kotlin).
  - Remove [api/kotlin-jvm-library.api](api/kotlin-jvm-library.api) and run
    `./gradlew apiDump`.
  - Replace module and package documentation in
    [Module.md](src/main/kotlin/Module.md).
  - Replace project description in [README.md](README.md).
- On GitHub
  - Generate a new Gradle encryption key with `openssl rand -base64 16` and set
    it as the action secret `GRADLE_ENCRYPTION_KEY`.
  - Enable repository setting _Allow GitHub Actions to create and approve pull
    requests_.
  - Set _GitHub Pages Source_ to _GitHub Actions_.
