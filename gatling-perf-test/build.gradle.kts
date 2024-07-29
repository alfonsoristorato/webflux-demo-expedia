plugins {
    kotlin("jvm") version serviceLibs.versions.kotlin.plugin.version
    kotlin("plugin.allopen") version serviceLibs.versions.kotlin.plugin.version

    alias(serviceLibs.plugins.gatling.gradle)
}

gatling {
    enterprise.closureOf<Any> {
        // Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/gradle_plugin/#working-with-gatling-enterprise-cloud
        // Enterprise Self-Hosted configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/gradle_plugin/#working-with-gatling-enterprise-self-hosted
    }
}

repositories {
    mavenCentral()
}
