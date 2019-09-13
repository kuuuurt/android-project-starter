package com.kurt.core.plugins.android.app

import com.android.build.gradle.AppExtension
import com.kurt.core.plugins.android.configureCommonAndroid
import com.kurt.core.plugins.android.configureCommonDependencies
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import java.io.FileInputStream

/**
 * Copyright 2019, White Cloak Technologies, Inc., All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/10/2019
 */

open class CoreAppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val appExtension = project.extensions.getByType<AppExtension>()
        appExtension.configureAndroidApplication(project)

        project.configureCommonDependencies()
    }

    private fun AppExtension.configureAndroidApplication(project: Project) {
        configureCommonAndroid()

        signingConfigs {
            create("release") {
                val keystorePropertiesFile = project.rootProject.file("keystore.properties")
                val keystoreProperties = java.util.Properties()

                keystoreProperties.load(FileInputStream(keystorePropertiesFile))

                keyAlias = keystoreProperties.getProperty("keyAlias")
                keyPassword = keystoreProperties.getProperty("keyPassword")
                storeFile = project.file(keystoreProperties.getProperty("storeFile"))
                storePassword = keystoreProperties.getProperty("storePassword")
            }
        }

        buildTypes {
            getByName("debug") {
                applicationIdSuffix = ".debug"
                versionNameSuffix = "-debug"
            }
            getByName("release") {
                signingConfig = signingConfigs.getByName("release")

                isCrunchPngs = true
                isMinifyEnabled = true
                isShrinkResources = true

                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

                isZipAlignEnabled = true
            }
        }

        productFlavors {
            create("dev") {
                dimension = "environment"
                applicationIdSuffix = ".dev"
                versionNameSuffix = "-dev"
            }
            create("staging") {
                dimension = "environment"
                applicationIdSuffix = ".staging"
                versionNameSuffix = "-staging"
            }
            create("production") {
                dimension = "environment"
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}