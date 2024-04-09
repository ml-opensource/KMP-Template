# Kotlin Multiplatform Project Setup

This Kotlin Multiplatform project targets Android and iOS using Compose Multiplatform.

💻 **Techstack**
-   <img src="https://kotlinlang.org/assets/images/favicon.svg?&v=8607ff59d5296c7642ecd72bd3daa79b" height=12 /> Kotlin Multiplatform
-   [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) for sharing UIs across multiple platforms with Kotlin
- 🔄 Kotlin Coroutines for async operations
- 🚀 Jetpack Architecture Components
- <img src="https://developer.android.com/static/images/spot-icons/jetpack-compose.svg" height = 16>  Jetpack Compose ❤️
- ☁️ [ktor](https://github.com/ktorio/ktor) for networking
- 🔗 [Kotlin Serialization](https://kotlinlang.org/docs/serialization.html) as primary JSON (de)serialization tool
- 🗡️ [koin](https://github.com/InsertKoinIO/koin) for Dependency Injection
- ✨ [Spotless](https://github.com/diffplug/spotless) for code-format control
- 🔍 [Detekt](https://github.com/detekt/detekt) for static code analysis

## Running the Project

### Android:

1. Open the project in Android Studio.
2. Go to the `Run/Debug Configurations` dialog.
3. Add a new configuration for the Android module.
4. Choose the `app` module from the module list.
5. Apply and run.

### iOS (First-time setup in Xcode):

1. Navigate to the `iosApp` directory.
2. Open an Xcode project (`*.xcodeproj`) or workspace (`*.xcworkspace`) in Xcode.

   - If there are both, prefer opening the `.xcworkspace`.

3. For first-time setup, ensure that you have the correct signing and team settings:

   - Go to the project editor by clicking on the project name in the navigator.
   - Select the target from the list.
   - In the Signing & Capabilities tab, choose your development team and ensure that signing is
     configured correctly.

4. Choose the correct target for your device or simulator in the scheme chooser at the top of the
   window.
5. Build and run the project.

## Structure

- `/composeApp`: Contains code shared across your Compose Multiplatform applications.
    - `commonMain`: Holds code that's common for all targets.
    - Platform-specific directories (e.g., `androidMain`, `iosMain`): Contain Kotlin code that will
      compile only for the designated platform. For iOS-specific Kotlin code, such as integration with
      Apple's CoreCrypto, uses `iosMain`.

- `/iosApp`: Contains the iOS application. This is the necessary entry point for the iOS app,
  even when sharing UI with Compose Multiplatform. This is also where to add any SwiftUI code for
  your project.

## Architecture
Template implements [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) and follows [best practices](https://developer.android.com/topic/architecture) provided by Google with some tweaks here and there

### Presentation layer
In our Android world, the Presentation layer or UI Layer is our Activities, Fragments, Jetpack Compose UI screens and components, and ViewModels. The Presentation layer interacts with the Domain Layer where our business logic happens.

### Domain layer
The domain layer contains the application's business logic. This layer should only work with abstractions and as such it would never know about how different layers look like. It shouldn’t know about any Databases, APIs, or even Android Framework.

### Data layer
The data layer is where the actual interactions happen between different data sources. This layer “implements” parts of the Domain layer and communicates with the APIs, Databases, and other services and SDKs.


## Tools
These are the tools used in the template, to improve the development, that you should be aware of:

### [Spotless](https://github.com/diffplug/spotless)
Spotless is a Gradle plugin used for consistent code formatting and style conventions across the project. You can use it running the following Gradle commands:

`./gradlew spotlessCheck` - Checks the style formatting and displays any issues

`./gradlew spotlessApply` - Same as above but automatically tries to fix most of the issues. If for any reason it can't, then a list of problems is displayed.

## Additional Resources

For more information on Kotlin Multiplatform, visit
the [official documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html).
