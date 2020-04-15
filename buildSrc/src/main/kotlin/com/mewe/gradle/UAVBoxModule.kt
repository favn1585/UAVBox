package com.mewe.gradle

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.JavaVersion.VERSION_1_8
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class MeweModule : Plugin<Project> {

    override fun apply(project: Project) {

        with(project) {
            plugins.apply("org.jetbrains.kotlin.android")
            plugins.apply("org.jetbrains.kotlin.kapt")
            plugins.apply("org.jetbrains.kotlin.android.extensions")
            plugins.apply("de.mannodermaus.android-junit5")

            dependencies {
                listOf(
                        Deps.junit5Api,
                        Deps.junit5Params,
                        Deps.junit5Kotlin,
                        Deps.mockitoInline,
                        Deps.mockitoCore,
                        Deps.mockitoKotlin,
                        Deps.truth,
                        Deps.kotlinTest,
                        Deps.mockk,
                        Deps.kotlinReflect
                ).forEach {
                    add("testImplementation", it)
                }

                listOf(
                        Deps.junit5VintageEngine,
                        Deps.junit5JupiterEngine
                ).forEach {
                    add("testRuntimeOnly", it)
                }

                listOf(
                        Deps.kotlinStdLib,
                        Deps.kotlinCoroutines,
                        Deps.kotlinCoroutinesAndroid,
                        Deps.kotlinCoroutinesRx2,
                        Deps.rxJava,
                        Deps.rxKotlin,
                        Deps.dagger,
                        Deps.timber,
                        Deps.androidxAnnotation,

                        //android-ktx
                        Deps.androidxCoreKtx,
                        Deps.androidxLifecycleExtensions,
                        Deps.androidxLifecycleViewModelKtx,
                        Deps.androidxCollectionKtx,
                        Deps.androidxActivityKtx,
                        Deps.androidxFragmentKtx,
                        Deps.androidxReactiveExtensionsKtx
                ).forEach {
                    add("implementation", it)
                }

                listOf(
                        Deps.daggerCompiler
                ).forEach {
                    add("kapt", it)
                }
            }

            project.plugins.all {

                when (this) {

                    is LibraryPlugin -> {
                        val extension = project.extensions.getByType(LibraryExtension::class.java)
                        extension.configureLibrary(project)
                    }

                    is AppPlugin -> {
                        // TODO
                    }
                }
            }
        }
    }
}


private fun LibraryExtension.configureLibrary(project: Project) {
    setCompileSdkVersion(Versions.compileSdkVer)
    buildToolsVersion = Versions.buildToolsVer

    buildTypes {
        maybeCreate("release").apply {
            isMinifyEnabled = false
        }

        maybeCreate("debug").apply {
            isMinifyEnabled = false
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    dataBinding.apply {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = false
        disable = setOf("LintBaseline")
    }

    flavorDimensions("mewe")

    productFlavors {
        register("consumer") {
            flavorDimensions("mewe")
        }

        register("pro") {
            flavorDimensions("mewe")
        }
    }

    defaultConfig.apply {
        minSdkVersion(Versions.minSdkVer)
        targetSdkVersion(Versions.targetSdkVer)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions.apply {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }
}