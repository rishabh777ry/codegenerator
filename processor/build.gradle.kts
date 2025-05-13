plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    google()
}


dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:2.1.20-1.0.32")
    implementation("com.squareup:kotlinpoet:1.14.2")
}

// Ensure the processor module is published
group = "com.example.ksp"
version = "1.0.0"

