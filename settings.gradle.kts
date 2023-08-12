pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://artifactory.2gis.dev/sdk-maven-release")
        }
    }
}

rootProject.name = "EventsApp"
include(":app")
include(":core:network")
include(":core:datamodel")
include(":data:events_manager")
include(":data:afisha")
include(":data:user")
include(":data:user_auth")
include(":core:shared_preference")
