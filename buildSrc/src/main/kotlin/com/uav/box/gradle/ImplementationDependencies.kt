package com.uav.box.gradle

import com.uav.box.gradle.LibraryVersions.activityKtxVer
import com.uav.box.gradle.LibraryVersions.androidJunitVer
import com.uav.box.gradle.LibraryVersions.appCompatVer
import com.uav.box.gradle.LibraryVersions.coreKtxVer
import com.uav.box.gradle.LibraryVersions.daggerAndroidSupportVer
import com.uav.box.gradle.LibraryVersions.espressoCoreVer
import com.uav.box.gradle.LibraryVersions.junitVer
import com.uav.box.gradle.LibraryVersions.kotlinVer
import com.uav.box.gradle.LibraryVersions.rxjavaVer
import com.uav.box.gradle.LibraryVersions.rxkotlinVer

object SystemVersions {
    const val compileSdkVer = 29
    const val targetSdkVer = 29
    const val buildToolsVer = "28.0.3"
    const val minSdkVer = 21
}

object LibraryVersions {
    // Implementation
    const val kotlinVer = "1.3.72"
    const val rxjavaVer = "2.2.10"
    const val rxkotlinVer = "2.3.0"
    const val activityKtxVer = "1.1.0"
    const val coreKtxVer = "1.2.0"
    const val daggerAndroidSupportVer = "2.24"
    const val appCompatVer = "1.1.0"

    // Test implementation
    const val junitVer = "4.13"

    // Android test implementation
    const val androidJunitVer = "1.1.1"
    const val espressoCoreVer = "3.2.0"
}

object ImplementationDependencies {
    // Android
    private const val appCompat = "androidx.appcompat:appcompat:$appCompatVer"

    // RX
    private const val rxjava = "io.reactivex.rxjava2:rxjava:$rxjavaVer"
    private const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:$rxkotlinVer"

    // Kotlin
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVer"

    // Ktx
    private const val activityKtx = "androidx.activity:activity-ktx:$activityKtxVer"
    private const val coreKtx = "androidx.core:core-ktx:$coreKtxVer"

    // Dagger
    private const val daggerAndroidSuport =
        "com.google.dagger:dagger-android-support:$daggerAndroidSupportVer"

    val implementation = listOf(
        appCompat,
        rxjava,
        rxkotlin,
        activityKtx,
        coreKtx,
        daggerAndroidSuport,
        kotlinStdLib
    )
}

object TestImplementationDependencies {
    private const val junit = "junit:junit:$junitVer"

    val testImplementation = listOf(
        junit
    )
}

object AndroidTestImplementationDependencies {

    private const val androidJunit = "androidx.test.ext:junit:$androidJunitVer"
    private const val espressoCore = "androidx.test.espresso:espresso-core:$espressoCoreVer"

    val androidTestImplementation = listOf(
        androidJunit,
        espressoCore
    )
}