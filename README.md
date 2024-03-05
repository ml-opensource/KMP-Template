# Kotlin Multiplatform Project Setup

This Kotlin Multiplatform project targets Android and iOS using Compose Multiplatform.

## Structure

- `/composeApp`: Contains code shared across your Compose Multiplatform applications.
  - `commonMain`: Holds code that's common for all targets.
  - Platform-specific directories (e.g., `androidMain`, `iosMain`): Contain Kotlin code that will
    compile only for the designated platform. For iOS-specific Kotlin code, such as integration with
    Apple's CoreCrypto, use `iosMain`.

- `/iosApp`: Contains the iOS application. This serves as the necessary entry point for the iOS app,
  even when sharing UI with Compose Multiplatform. This is also where to add any SwiftUI code for
  your project.

## Running the Project

### Android:

1. Open the project in Android Studio.
2. Go to the `Run/Debug Configurations` dialog.
3. Add a new configuration for the Android module.
4. Choose the `app` module from the module list.
5. Apply and run.

### iOS (First-time setup in Xcode):

1. Navigate to the `iosApp` directory.
2. If there's an Xcode project (`*.xcodeproj`) or workspace (`*.xcworkspace`), open it in Xcode.

   - If there's both, prefer opening the `.xcworkspace`.

3. For first-time setup, ensure that you have the correct signing and team settings:

   - Go to the project editor by clicking on the project name in the navigator.
   - Select the target from the list.
   - In the Signing & Capabilities tab, choose your development team and ensure that signing is
     configured correctly.

4. Choose the correct target for your device or simulator in the scheme chooser at the top of the
   window.
5. Build and run the project.

## Tools
These are the tools used in the template, to improve the development, that you should be aware of:

### [Spotless](https://github.com/diffplug/spotless)
Spotless is a Gradle plugin used for consistent code formatting and style conventions across the project. You can use it running the following Gradle commands:

`./gradlew spotlessCheck` - Checks the style formatting and displays any issues

`./gradlew spotlessApply` - Same as above but automatically try to fix most of the issues. If for any reason it can't, then a list of problems is displayed.

## Additional Resources

For more information on Kotlin Multiplatform, visit
the [official documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html).
