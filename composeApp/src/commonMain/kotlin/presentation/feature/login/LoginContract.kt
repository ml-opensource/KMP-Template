package presentation.feature.login

/**
 * UI State that represents LoginScreen
 **/
data class LoginScreenState(
    var email: String = "kminchelle",
    var password: String = "0lelplR",
    val isLoading: Boolean = false,
    val error: String? = null,
    val loginButtonEnabled: Boolean = false,
    val isLoggedIn: Boolean = false,
) {
    // Needed for SwiftUI
    constructor() : this(
        email = "kminchelle",
        password = "0lelplR",
        isLoading = false,
        error = null,
        loginButtonEnabled = false,
        isLoggedIn = false
    )
}

/**
 * Login Actions emitted from the UI Layer
 * passed to the viewmodel to handle
 **/
sealed class LoginIntent {
    data class OnPasswordChange(val pass: String) : LoginIntent()
    data class OnEmailChange(val email: String) : LoginIntent()
    data object Login : LoginIntent()
}
