package com.uav.box.gradle

import com.uav.box.gradle.LibraryVersions.activityKtxVer
import com.uav.box.gradle.LibraryVersions.daggerAndroidSupportVer
import com.uav.box.gradle.LibraryVersions.rxjavaVer
import com.uav.box.gradle.LibraryVersions.rxkotlinVer

object SystemVersions {
    const val compileSdkVer = 29
    const val targetSdkVer = 29
    const val buildToolsVer = "28.0.3"
    const val minSdkVer = 21
}

object LibraryVersions {
    const val rxjavaVer = "2.2.10"
    const val rxkotlinVer = "2.3.0"
    const val activityKtxVer = "1.1.0"
    const val daggerAndroidSupportVer = "2.24"
}

object Dependencies {
    private const val rxjava = "io.reactivex.rxjava2:rxjava:$rxjavaVer"
    private const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:$rxkotlinVer"
    private const val activityKtx = "androidx.activity:activity-ktx:$activityKtxVer"
    private const val daggerAndroidSuport =
        "com.google.dagger:dagger-android-support:$daggerAndroidSupportVer"


    val commonDependencies = listOf(
        rxjava,
        rxkotlin,
        activityKtx,
        daggerAndroidSuport
    )
}