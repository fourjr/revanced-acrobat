rootProject.name = "revanced-acrobat"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/revanced/registry")
//            url = uri("https://maven.pkg.github.com/OWNER/REPOSITORY")
            credentials {
                username = providers.gradleProperty("gpr.user").orNull ?: "username"
                password = providers.gradleProperty("gpr.key").orNull ?: "token"
            }
        }
    }
}


plugins {
    id("app.revanced.patches") version "1.0.0-dev.5"
}
