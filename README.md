# Kotlin Multiplatform Project Setup

![kotlin-version](https://img.shields.io/badge/kotlin-1.9.23-blue)

This Kotlin Multiplatform project targets Android and iOS using Compose Multiplatform.

<p align="center">
 <img src="https://github.com/monstar-lab-oss/KMP-Template/assets/95737419/0917435d-5e69-495c-8abc-bdeadb3bae60" width="25%" height="25%" style="margin-right: 50px;" />
 <img src="https://github.com/monstar-lab-oss/KMP-Template/assets/95737419/79919fd2-4177-45fd-b65d-4324dbfa3db9" width="25%" height="25%" />
</p>


💻 **Techstack**
-   <img src="https://kotlinlang.org/assets/images/favicon.svg?&v=8607ff59d5296c7642ecd72bd3daa79b" height=12 /> [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
-   [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) for sharing UIs across multiple platforms with Kotlin
- <img src="https://developer.apple.com/assets/elements/icons/swiftui/swiftui-96x96_2x.png" height=12 /> [Swift UI](https://developer.apple.com/xcode/swiftui/) (Optional)
- 🗡️ [koin](https://github.com/InsertKoinIO/koin) for Dependency Injection
- ☁️ [ktor](https://github.com/ktorio/ktor) for networking
- 🔗 [Kotlin Serialization](https://kotlinlang.org/docs/serialization.html) as primary JSON (de)serialization tool
- 🔄 [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for async operations
- 📦 [Room (Kotlin Multiplatform)](https://developer.android.com/kotlin/multiplatform/room) for persistent SQL storage
- 🗂 [DataStore (Kotlin Multiplatform)](https://developer.android.com/kotlin/multiplatform/datastore) for persistent NoSQL storage
- 📱 Shared [ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel) by AndroidX
- 🧭 [Voyager](https://voyager.adriel.cafe/navigation) for navigation
- 📲 [SKIE](https://skie.touchlab.co/) - Swift Kotlin Interface Enhancer by Touchlab
- 🖼 Coil for loading images
- ✨ [Spotless](https://github.com/diffplug/spotless) for code-format control
- 🔍 [Detekt](https://github.com/detekt/detekt) for static code analysis

📒 **Todo**
- Jetpack Navigation
- Deeplink Support
- Build Logic

## Project Setup

### Android:

1. Open the project in Android Studio.
2. Wait for the build to finish.
3. Select `composeApp` from the `Run/Debug` Configurations.
4. Apply and run.

### iOS:

1. Navigate to the `KMP-Template/iosApp` directory.
2. For first-time setup:
    - Open terminal in that directory and run the command `pod install`.
    - It’ll generate the `iosApp.xcworkspace` file.
3. Open the `iosApp.xcworkspace` file in Xcode.
4. Choose the correct target for your device or simulator in the scheme chooser at the top of the window.
5. Build and run.

### iOS with Swift UI:

If you want to run the iOS app with swift UI (not compose multiplatform)
1. Open the `iosApp.xcworkspace` file in Xcode.
2. Navigate to the `iosApp/presentation/ContentView` file in Xcode.
3. Inside the ContentView body, uncomment the line `SplashScreen()` and comment out the `ComposeView().ignoresSafeArea(.keyboard)`.
4. Build and run.

## Structure

- `/composeApp`: Contains code shared across the Compose Multiplatform applications.
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
The Presentation layer or UI Layer is our Jetpack Compose UI screens and components, and ViewModels. The Presentation layer interacts with the Domain Layer where our business logic resides.

### Domain layer
The domain layer contains the application's business logic. This layer only works with abstractions and as such it never knows about how different layers look like. It doesn't know about any Databases, APIs, or even any Frameworks.

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
