pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        //Sonatype S01
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Waze Lachenal"
include(":app")
