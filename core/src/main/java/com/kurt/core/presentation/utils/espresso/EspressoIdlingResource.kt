package com.kurt.core.presentation.utils.espresso

/**
 * Object for tagging asynchronous operations as idle for Espresso tests
 *
 * * Borrowed from Android Testing Codelabs
 * https://github.com/googlecodelabs/android-testing
 */
object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    @JvmField val countingIdlingResource = SimpleCountingIdlingResource(RESOURCE)

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow()) {
            countingIdlingResource.decrement()
        }
    }
}