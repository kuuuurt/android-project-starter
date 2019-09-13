package com.kurt.core.plugins.android.library

import com.android.build.gradle.LibraryExtension
import com.kurt.core.plugins.android.configureCommonAndroid
import com.kurt.core.plugins.android.configureCommonDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Copyright 2019, White Cloak Technologies, Inc., All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/10/2019
 */

open class CoreLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val libraryExtension = project.extensions.getByType<LibraryExtension>()
        libraryExtension.configureAndroidLibrary()

        project.configureCommonDependencies()
    }

    private fun LibraryExtension.configureAndroidLibrary() {
        configureCommonAndroid()

        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                consumerProguardFiles("consumer-rules.pro")
            }
        }

        productFlavors {
            create("dev")
            create("staging")
            create("production")
        }
    }
}