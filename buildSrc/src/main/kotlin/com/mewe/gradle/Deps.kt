package com.mewe.gradle

import com.mewe.gradle.Versions.androidDbFrameworkVer
import com.mewe.gradle.Versions.androidXAnnotationVer
import com.mewe.gradle.Versions.androidXAppCompatVer
import com.mewe.gradle.Versions.androidXCardViewVer
import com.mewe.gradle.Versions.androidXLegacy
import com.mewe.gradle.Versions.androidXMaterialVer
import com.mewe.gradle.Versions.androidXPalleteVer
import com.mewe.gradle.Versions.androidXRecyclerViewVer
import com.mewe.gradle.Versions.bindingCollectionVersion
import com.mewe.gradle.Versions.butterknifeVer
import com.mewe.gradle.Versions.cameraViewVer
import com.mewe.gradle.Versions.constraintLayoutVer
import com.mewe.gradle.Versions.dagger2_version
import com.mewe.gradle.Versions.gifDrawableVer
import com.mewe.gradle.Versions.gsonVer
import com.mewe.gradle.Versions.jUnit5KotlinVer
import com.mewe.gradle.Versions.jUnit5Ver
import com.mewe.gradle.Versions.junitVer
import com.mewe.gradle.Versions.kotlinCoroutinesVer
import com.mewe.gradle.Versions.kotlin_version
import com.mewe.gradle.Versions.mockWebServerVersion
import com.mewe.gradle.Versions.mockitoKotlinVer
import com.mewe.gradle.Versions.mockitoVer
import com.mewe.gradle.Versions.mockkVer
import com.mewe.gradle.Versions.moshiVer
import com.mewe.gradle.Versions.okhttpVer
import com.mewe.gradle.Versions.retrofitVer
import com.mewe.gradle.Versions.rxAndroidVer
import com.mewe.gradle.Versions.rxJavaVer
import com.mewe.gradle.Versions.rxKotlinVer
import com.mewe.gradle.Versions.sqlbriteKotlinVer
import com.mewe.gradle.Versions.timberVer
import com.mewe.gradle.Versions.truthVer

object Versions {
    val kotlin_version = "1.3.70"
    val kotlinCoroutinesVer = "1.3.4"
    val androidGradlePluginVer = "3.5.3"

    val compileSdkVer = 29
    val targetSdkVer = 29
    val buildToolsVer = "28.0.3"
    val minSdkVer = 23

    val androidXLegacy = "1.0.0"
    val androidXAppCompatVer = "1.2.0-alpha02"
    val androidXRecyclerViewVer = "1.1.0"
    val androidXMaterialVer = "1.2.0-alpha02"
    val androidXPalleteVer = "1.0.0"
    val androidDbFrameworkVer = "1.1.1"
    val androidXAnnotationVer = "1.1.0"
    val androidXCardViewVer = "1.0.0"
    val androidXVectordrawableVer = "1.1.0"
    val androidXBrowserVer = "1.2.0"
    val androidXPercentLayoutVer = "1.0.0"

    val cameraViewVer = "2.6.2"

    val okhttpVer = "3.14.4"
    val gsonVer = "2.8.5"
    val butterknifeVer = "10.2.0"
    val parcelVer = "1.1.8"
    val glideVer = "4.11.0"
    val timberVer = "4.7.1"
    val junitVer = "4.12"
    val mockitoVer = "2.27.0"
    val mockitoKotlinVer = "1.4.0"
    val espressoVer = "3.0.0"
    val leakCanaryVer = "2.2"
    val rxAndroidVer = "2.1.1"
    val rxKotlinVer = "2.3.0"
    val rxJavaVer = "2.2.8"
    val retrofitVer = "2.6.1"
    val dagger2_version = "2.24"
    val androidJobsVer = "1.3.0-rc1"
    val powerMockitoBer = "2.0.2"
    val jUnit5Ver = "5.5.2"
    val jUnit5KotlinVer = "0.0.1"
    val truthVer = "0.44"
    val rxBindingVer = "3.0.0"
    val sqlDelightVer = "0.9.0"
    val sqlBriteVer = "3.2.0"
    val autovalueVer = "1.6.6"
    val autoValueParcelVer = "0.2.8"
    val autoValueGsonVer = "1.1.1"
    val exoPlayerVer = "2.11.3"
    val discreteSeekbarVer = "1.0.1"
    val constraintLayoutVer = "1.1.3"
    val moshiVer = "1.8.0"
    val sqlbriteKotlinVer = "3.2.0"
    val mockWebServerVersion = "3.14.4"

    val mockkVer = "1.9"

    val detektVersion = "1.2.2"

    val bindingCollectionVersion = "3.2.0"

    val matomoVer = "4.1.1"

    val gifDrawableVer = "1.2.8"

    val ffmpegVer = "4.3.1.LTS"

    val calendarViewVer = "0.3.4"
}

object Deps {
    //testImplementation
    val junit4 = "junit:junit:$junitVer"
    val junit5Api = "org.junit.jupiter:junit-jupiter-api:$jUnit5Ver"
    val junit5Params = "org.junit.jupiter:junit-jupiter-params:$jUnit5Ver"
    val junit5Kotlin = "de.jodamob.junit5:junit5-kotlin:$jUnit5KotlinVer"
    val mockitoInline = "org.mockito:mockito-inline:$mockitoVer"
    val mockitoCore = "org.mockito:mockito-core:$mockitoVer"
    val mockitoAndroid = "org.mockito:mockito-android:$mockitoVer"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
    val mockitoKotlinLegacy = "com.nhaarman:mockito-kotlin:$mockitoKotlinVer"
    val truth = "com.google.truth:truth:$truthVer"
    val kotlinTest = "io.kotlintest:kotlintest-runner-junit5:3.3.2"
    val mockk = "io.mockk:mockk:$mockkVer"
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"

    //testRuntimeOnly
    val junit5VintageEngine = "org.junit.vintage:junit-vintage-engine:$jUnit5Ver"
    val junit5JupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$jUnit5Ver"

    //androidTestImplementation
    val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha02"
    val espressoTestRules = "androidx.test:rules:1.3.0-alpha02"

    //implementation
    val androidxLegacy = "androidx.legacy:legacy-support-v4:$androidXLegacy"
    val androidAppCompat = "androidx.appcompat:appcompat:$androidXAppCompatVer"
    val androidRecyclerView = "androidx.recyclerview:recyclerview:$androidXRecyclerViewVer"
    val androidMaterial = "com.google.android.material:material:$androidXMaterialVer"
    val androidPalette = "androidx.palette:palette:$androidXPalleteVer"
    val androidDbFramework = "android.arch.persistence:db-framework:$androidDbFrameworkVer"
    val androidxAnnotation = "androidx.annotation:annotation:$androidXAnnotationVer"
    val androidXCardView = "androidx.cardview:cardview:$androidXCardViewVer"
    val androidXConstraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVer"

    val otaliastudiosCameraView = "com.otaliastudios:cameraview:$cameraViewVer"
    val blurry = "jp.wasabeef:blurry:3.0.0"

    val bindingCollectionAdapter = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:$bindingCollectionVersion"
    val bindingCollectionAdapterRecyclerView = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:$bindingCollectionVersion"
    val bindingCollectionvAdapterViewpager2 = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-viewpager2:$bindingCollectionVersion"

    //androidx ktxandroidx.lifecycle:lifecycle-viewmodel
    val androidxCoreKtx = "androidx.core:core-ktx:1.2.0"
    val androidxCollectionKtx = "androidx.collection:collection-ktx:1.1.0"
    val androidxLifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    val androidxLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    val androidxActivityKtx = "androidx.activity:activity-ktx:1.1.0"
    val androidxFragmentKtx = "androidx.fragment:fragment-ktx:1.2.4"
    val androidxReactiveExtensionsKtx = "androidx.lifecycle:lifecycle-reactivestreams-ktx:2.2.0"

    val timber = "com.jakewharton.timber:timber:$timberVer"
    val butterKnife = "com.jakewharton:butterknife:$butterknifeVer"
    val materialProgress = "com.pnikosis:materialish-progress:1.7"

    val gson = "com.google.code.gson:gson:$gsonVer"
    val okhttp3 = "com.squareup.okhttp3:okhttp:$okhttpVer"

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVer"
    val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesVer"
    val kotlinCoroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$kotlinCoroutinesVer"

    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVer"
    val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVer"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVer"

    val moshi = "com.squareup.moshi:moshi:$moshiVer"
    val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$moshiVer"
    val moshiKotlinCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVer"

    val androidThreetenabp = "com.jakewharton.threetenabp:threetenabp:1.2.3"
    val jdkThreeTenadp = "org.threeten:threetenbp:1.4.2"

    val jdkTimberStub = "com.github.radzio:timber-stub:0.0.5"

    val easingInterpolator = "com.daasuu:EasingInterpolator:1.0.0"

    val sqlbriteKotlin = "com.squareup.sqlbrite3:sqlbrite-kotlin:$sqlbriteKotlinVer"

    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVer"
    val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVer"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVer"
    val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVer"

    val autoValue = "com.google.auto.value:auto-value-annotations:${Versions.autovalueVer}"
    val autoValueProcessor = "com.google.auto.value:auto-value:${Versions.autovalueVer}"

    val dagger = "com.google.dagger:dagger:$dagger2_version"
    val daggerCompiler = "com.google.dagger:dagger-compiler:$dagger2_version"

    val viewPagerIndicator = "com.viewpagerindicator:library:2.4.1"

    val exoPlayer = "com.google.android.exoplayer:exoplayer:${Versions.exoPlayerVer}"
    val exoPlayerOkHttp = "com.google.android.exoplayer:extension-okhttp:${Versions.exoPlayerVer}"

    val matomo = "org.matomo.sdk:tracker:${Versions.matomoVer}"
    val gifDrawable = "pl.droidsonroids.gif:android-gif-drawable:${gifDrawableVer}"
    val youtubePlayer = "com.pierfrancescosoffritti.androidyoutubeplayer:core:10.0.5"

    val ffmpegLib = "com.arthenica:mobile-ffmpeg-min-gpl:${Versions.ffmpegVer}"

    val calendarView = "com.github.kizitonwose:CalendarView:${Versions.calendarViewVer}"
}