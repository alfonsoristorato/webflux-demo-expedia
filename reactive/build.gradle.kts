plugins {
    alias(serviceLibs.plugins.spring.boot)
    alias(serviceLibs.plugins.spring.dependency.management)
    alias(serviceLibs.plugins.gradle.ktlint)
    kotlin("jvm") version serviceLibs.versions.kotlin.plugin.version
    kotlin("plugin.spring") version serviceLibs.versions.kotlin.plugin.version
}

group = "webfluxDemo"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring and Configuration
    implementation(serviceLibs.spring.boot.starter.webflux)

    // Kotlin specific
    implementation(serviceLibs.jackson.module.kotlin)
    implementation(serviceLibs.kotlin.reflect)

    // Testing
    testImplementation(serviceLibs.test.spring.boot.starter.test)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
        allWarningsAsErrors = false
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
