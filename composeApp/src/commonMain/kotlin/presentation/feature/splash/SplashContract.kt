package presentation.feature.splash

import domain.usecase.User
import platform.Greeting

data class SplashScreenState(
    val user: User? = null,
    val showContent: Boolean = false,
    val greeting: String = Greeting().greet(),
) {
    // Needed for SwiftUI
    constructor() : this(
        user = null,
        showContent = false,
        greeting = Greeting().greet()
    )
}

sealed class SplashScreenIntent {
    data class OnContentVisibilityChange(val show: Boolean) : SplashScreenIntent()
}
