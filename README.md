# Android Project Starter
My starter for Android projects. 

Contains base files, utils, and helpers for code reuse and ease.

This is the way that works for me and it might not fit yours. If what I'm doing is bad practice, Leave an issue/suggestion for improvements. 

## Libraries and Tools Used

- Gradle Kotlin DSL
- Kotlin
- AndroidX
- Material Components
- Android Architecture Components
    - Lifecycle and ViewModel
    - Navigation
        - SafeArgs
- Retrofit
- Moshi
- Kotlin Coroutines
- Dagger 2

## Using the Gradle Plugin

The `buildSrc` folder contains build classes for Gradle. For applications, use the `CoreAppPlugin`. For libraries, use the `CoreLibraryPlugin`

To use them, apply them in your app/library modules:

```kotlin
plugins {
    id("com.kurt.core.app")
}

// OR

import com.kurt.core.plugins.android.app.CoreAppPlugin

apply<CoreAppPlugin>()
```

```kotlin
plugins {
    id("com.kurt.core.library")
}

// OR

import com.kurt.core.plugins.android.app.CoreLibraryPlugin

apply<CoreLibraryPlugin>()
```

These plugins, automatically import the dependencies for each app/library module and does the necessary COMMON configurations. These are only for the same configurations per module so you don't have to copy paste each code per module. Very useful in a modular project.
Modify them to your taste as needed (e.g. Package Names, New Libraries, Flavors and Build Types)

## Using BaseFragment

The `BaseFragment` is an abstract class that accepts the layout ID of your fragment and requires you to implement a `viewModel` for your AAC `ViewModel` and 3 functions for organization:

`setupViews()` for your view configurations. If you wanna set the `TextView` or `Button` string, do it here. Anything related to view setup should be here. This is also where you should get a reference to the views so you have a reference on the other functions.

```kotlin
private lateinit var txtView: TextView

override fun setupViews(view: View) {
    txtView = view.findViewById(R.id.txt_view)
} 

override fun setupInputs() {
    // Setup a click listener for txtView
    txtView.setOnClickListener { ... }
}
```
 

`setupInputs()` for setting up your inputs (duh). This is where you set click listeners or text watchers for your view. Anything that handles user input should be handled here.

`setupOutputs()` for observing `viewModel` outputs. This is where you just subscribe to the `ViewModel` and handle the output from there.

These 3 functions are executed on `onViewCreated()`
 

**Overridable**:
 
`inject()` for your DI. This is run before `onCreate()` to ensure that your dependencies are provided to you. You can leave this blank if you don't have any dependency injection

## Authors

- Kurt Renzo Acosta - [kurt.r.acosta@gmail.com](mailto:kurt.r.acosta@gmail.com)

## License


    Copyright 2019 Kurt Renzo Acosta

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at


        http://www.apache.org/licenses/LICENSE-2.0


    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
