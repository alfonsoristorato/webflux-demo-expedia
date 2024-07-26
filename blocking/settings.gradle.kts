rootProject.name = "blocking"

dependencyResolutionManagement {
    versionCatalogs {
        create("serviceLibs") {
            from(files("../libs.versions.toml"))
        }
    }
}
