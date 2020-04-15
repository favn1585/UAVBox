buildscript {

    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.70")
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

plugins {
    `kotlin-dsl`
    kotlin("plugin.serialization") version "1.3.70"
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

gradlePlugin {
    plugins {
        register("UAVBoxModule") {
            id = "UAVBoxModule"
            implementationClass = "com.uav.box.gradle.UAVBoxModule"
        }
    }
}

dependencies {
    implementation(gradleApi())

    implementation("com.android.tools.build:gradle:3.6.2")
    implementation("io.ktor:ktor-client-core:1.3.1")
    implementation("io.ktor:ktor-client-okhttp:1.3.1")
    implementation("io.ktor:ktor-client-json:1.3.1")
    implementation("io.ktor:ktor-client-auth-jvm:1.3.1")
    implementation("io.ktor:ktor-client-serialization-jvm:1.3.1")
}