package com.kurt.core.plugins.android

import com.kurt.core.dependencies.AndroidDependencies
import com.kurt.core.dependencies.AndroidTestDependencies
import com.kurt.core.dependencies.TestDependencies
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Copyright 2019, White Cloak Technologies, Inc., All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/10/2019
 */
internal fun Project.configureCommonDependencies() {
    configureDependencies()
    configureTestDependencies()
    configureAndroidTestDependencies()
}

internal fun Project.configureDependencies() = dependencies {
    add("implementation", AndroidDependencies.KOTLIN)

    add("implementation", AndroidDependencies.NAVIGATION_FRAGMENT_KTX)
    add("implementation", AndroidDependencies.NAVIGATION_UI_KTX)

    add("implementation", AndroidDependencies.LIFECYCLE_EXTENSIONS)
    add("implementation", AndroidDependencies.LIFECYCLE_VIEWMODEL_KTX)

    add("implementation", AndroidDependencies.APPCOMPAT)
    add("implementation", AndroidDependencies.CORE_KTX)
    add("implementation", AndroidDependencies.ACTIVITY_KTX)
    add("implementation", AndroidDependencies.FRAGMENT_KTX)

    add("implementation", AndroidDependencies.MATERIAL_COMPONENTS)
    add("implementation", AndroidDependencies.SWIPE_REFRESH_LAYOUT)
    add("implementation", AndroidDependencies.CONSTRAINT_LAYOUT)

    add("implementation", AndroidDependencies.COROUTINES)

    add("implementation", AndroidDependencies.MOSHI)

    add("implementation", AndroidDependencies.RETROFIT)
    add("implementation", AndroidDependencies.RETROFIT_MOSHI_CONVERTER)

    add("implementation", AndroidDependencies.DAGGER2)

    add("implementation", AndroidDependencies.ESPRESSO_IDLING_RESOURCE)
}

internal fun Project.configureTestDependencies() = dependencies {
    add("testImplementation", TestDependencies.JUNIT)
}

internal fun Project.configureAndroidTestDependencies() = dependencies {
    add("androidTestImplementation", AndroidTestDependencies.JUNIT)
    add("androidTestImplementation", AndroidTestDependencies.RUNNER)
    add("androidTestImplementation", AndroidTestDependencies.ESPRESSO_CORE)
    add("androidTestImplementation", AndroidTestDependencies.CORE_KTX)
    add("androidTestImplementation", AndroidTestDependencies.JUNIT_KTX)
    add("androidTestImplementation", AndroidTestDependencies.RULES)
}
