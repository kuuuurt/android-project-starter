package com.kurt.core.plugins.android

import com.android.build.gradle.BaseExtension

/**
 * Copyright 2019, White Cloak Technologies, Inc., All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/10/2019
 */

internal fun BaseExtension.configureCommonAndroid() {
    compileSdkVersion(Properties.COMPILE_SDK_VERSION)
    defaultConfig {
        minSdkVersion(Properties.MIN_SDK_VERSION)
        targetSdkVersion(Properties.TARGET_SDK_VERSION)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions("environment")
}