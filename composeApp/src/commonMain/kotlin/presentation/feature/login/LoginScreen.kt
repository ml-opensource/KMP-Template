package presentation.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import presentation.components.appbutton.AppButton
import presentation.components.apptextfield.AppTextField
import presentation.theme.Theme

@Composable
fun LoginScreen(
    state: LoginState,
    action: (LoginIntent) -> Unit,
    navigate: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Login",
                        fontWeight = FontWeight.Black,
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                backgroundColor = Theme.colors.primary,
                contentColor = Theme.colors.onPrimary,
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(Theme.dimensions.big1)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AppTextField(
                value = state.email,
                onValueChange = { text ->
                    action(LoginIntent.OnEmailChange(email = text))
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Username") },
            )

            Spacer(modifier = Modifier.size(Theme.dimensions.medium3))

            AppTextField(
                value = state.password,
                onValueChange = { text ->
                    action(LoginIntent.OnPasswordChange(text))
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                placeholder = { Text(text = "Password") },
            )

            Spacer(modifier = Modifier.size(Theme.dimensions.medium3))

            AppButton(
                text = "Login",
                onClick = {
                    action(LoginIntent.Login)
                },
                modifier = Modifier.fillMaxWidth(),
                isLoading = state.isLoading,
            )

            if (state.isLoggedIn) navigate()
        }
    }
}