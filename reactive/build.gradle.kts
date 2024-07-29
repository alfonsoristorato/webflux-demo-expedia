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
    implementation(serviceLibs.spring.boot.starter.data.r2dbc)
    implementation(serviceLibs.spring.boot.starter.oauth2.resource.server)
    implementation(serviceLibs.spring.boot.starter.security)

    // Persistence
    implementation(serviceLibs.postgresql.r2dbc)

    // Flyway
    implementation(serviceLibs.flyway.core)
    implementation(serviceLibs.flyway.database.postgresql)
    implementation(serviceLibs.postgresql)

    // Kotlin specific
    implementation(serviceLibs.jackson.module.kotlin)
    implementation(serviceLibs.reactor.kotlin.extensions)
    implementation(serviceLibs.kotlin.reflect)

    // Testing
    testImplementation(serviceLibs.test.spring.boot.starter.test)

//    this is needed if you get an error about macOs DNS resolutions
    implementation("io.netty:netty-all")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
        allWarningsAsErrors = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Copy>("copyMigrations") {
    from("../migrations")
    include("*.sql")
    into("src/main/resources/db/migration")
    dependsOn("processResources")
}

tasks.named("build") { dependsOn("copyMigrations") }
