rootProject.name = "codegenerator"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":processor")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        kotlin("multiplatform").version("1.9.22")
        id("com.android.library").version("8.1.2")
        id("com.google.devtools.ksp").version("2.1.20-1.0.32")
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":processor")

