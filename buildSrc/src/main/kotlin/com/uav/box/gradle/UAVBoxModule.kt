package com.uav.box.gradle

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.JavaVersion.VERSION_1_8
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class UAVBoxModule : Plugin<Project> {

    override fun apply(project: Project) {

        with(project) {
            plugins.apply("org.jetbrains.kotlin.android")
            plugins.apply("org.jetbrains.kotlin.kapt")
            plugins.apply("org.jetbrains.kotlin.android.extensions")

            dependencies {
                ImplementationDependencies.implementation.forEach {
                    add("implementation", it)
                }

                TestImplementationDependencies.testImplementation.forEach {
                    add("testImplementation", it)
                }

                AndroidTestImplementationDependencies.androidTestImplementation.forEach {
                    add("androidTestImplementation", it)
                }
            }

            project.plugins.all {

                when (this) {
                    is LibraryPlugin -> {
                        val extension = project.extensions.getByType(LibraryExtension::class.java)
                        extension.configureLibrary(project)
                    }
                }
            }
        }
    }
}


private fun LibraryExtension.configureLibrary(project: Project) {
    setCompileSdkVersion(SystemVersions.compileSdkVer)
    buildToolsVersion = SystemVersions.buildToolsVer

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    dataBinding.apply {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = false
    }

    defaultConfig.apply {
        minSdkVersion(SystemVersions.minSdkVer)
        targetSdkVersion(SystemVersions.targetSdkVer)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions.apply {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}