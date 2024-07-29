rootProject.name = "gatling-perf-test"

dependencyResolutionManagement {
    versionCatalogs {
        create("serviceLibs") {
            from(files("../libs.versions.toml"))
        }
    }
}

