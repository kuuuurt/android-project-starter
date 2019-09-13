package com.kurt.core.dependencies

/**
 * Copyright 2019, White Cloak Technologies, Inc., All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/10/2019
 */

object AndroidDependencies {
    val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${GlobalVersions.KOTLIN}"

    // Navigation
    val NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${GlobalVersions.NAVIGATION}"
    val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${GlobalVersions.NAVIGATION}"

    // LiveData and ViewModel
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    // AndroidX
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
    const val CORE_KTX = "androidx.core:core-ktx:1.0.2"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.0.0"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.1.0"
    const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

    // Material Components
    const val MATERIAL_COMPONENTS = "com.google.android.material:material:1.1.0-alpha09"

    // ConstraintLayout
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"

    // Coroutines
    const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${GlobalVersions.COROUTINES}"

    // Dagger 2
    const val DAGGER2 = "com.google.dagger:dagger-android:${GlobalVersions.DAGGER2}"
    const val DAGGER2_COMPILER = "com.google.dagger:dagger-compiler:${GlobalVersions.DAGGER2}"

    // Espress Idling Resource
    const val ESPRESSO_IDLING_RESOURCE =
        "androidx.test.espresso:espresso-idling-resource:${GlobalVersions.ESPRESSO}"

    // Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    // Moshi
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"

    object Versions {
        const val RETROFIT = "2.6.1"
        const val MOSHI = "1.8.0"
        const val LIFECYCLE = "2.1.0-rc01"
    }
}