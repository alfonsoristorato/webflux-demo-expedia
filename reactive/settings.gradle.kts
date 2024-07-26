rootProject.name = "reactive"

dependencyResolutionManagement {
    versionCatalogs {
        create("serviceLibs") {
            from(files("../libs.versions.toml"))
        }
    }
}
