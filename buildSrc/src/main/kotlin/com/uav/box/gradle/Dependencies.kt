package com.uav.box.gradle

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
}

object Dependencies {
    const val rxjava = "io.reactivex.rxjava2:rxjava:$rxjavaVer"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:$rxkotlinVer"
}