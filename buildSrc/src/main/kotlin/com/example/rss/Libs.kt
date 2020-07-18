package com.example.rss

object Libs {
    object Plugins {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Modules {
        const val domain = ":domain"
        const val data = ":data"
    }

    object Jetpack {
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.arch}"
        const val reactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.arch}"
        const val lifecycleVmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.arch}"
        const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupp}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val annotations = "androidx.annotation:annotation:${Versions.material}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Common {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val daggerAndroid = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val daggerAndroidCompiler =
            "com.google.dagger:dagger-android-processor:${Versions.dagger}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitSimpleXmlConverter = "com.squareup.retrofit2:converter-simplexml:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val retrofitRx = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
        const val stetho_OkHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
        const val sdp = "com.intuit.sdp:sdp-android:${Versions.sdp}"
        const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"
        const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"
    }


    object Firebase {
        const val analytics = "com.google.firebase:firebase-analytics:${Versions.analytics}"
        const val messaging = "com.google.firebase:firebase-messaging:${Versions.messaging}"
        const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
        const val core = "com.google.firebase:firebase-core:${Versions.core}"
        const val tagManager = "com.google.android.gms:play-services-tagmanager:${Versions.tagManager}"
    }

    object Testing {
        const val junit = "junit:junit:${Versions.junit}"
        const val testRunner = "androidx.test:runner:${Versions.testRunner}"
        const val esperesso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val mockitoKotlin = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockitoKotlin}"
        const val archTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    }
}
