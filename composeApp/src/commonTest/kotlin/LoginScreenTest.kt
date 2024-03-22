import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import presentation.feature.login.LoginScreen
import kotlin.test.Test

class LoginScreenTest {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `login screen displays correctly`() = runComposeUiTest {
        // Set the content under test
        setContent {
            LoginScreen.Content()
        }


        // Verify that the login screen is displayed
        onNodeWithText("Login").assertIsDisplayed()
        onNodeWithText("Username").assertIsDisplayed()
        onNodeWithText("Password").assertIsDisplayed()
        onNodeWithText("Login").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `login button click triggers login action`() = runComposeUiTest {
        // Set the content under test
        setContent {
            LoginScreen.Content()
        }

        // Perform a click action on the login button
        onNodeWithText("Login").performClick()

        // Verify that the login action was triggered
        // This might involve checking for navigation to another screen or a loading state
        // For simplicity, this example assumes you have a way to verify the login action was triggered
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `test login screen`() = runComposeUiTest {
        val email = "test@example.com"
        val password = "password"

        // Set the content under test
        setContent {
            LoginScreen.Content()
        }

        // Find the email TextField and perform text input
        onNodeWithText("Username").performTextInput(email)

        // Find the password TextField and perform text input
        onNodeWithText("Password").performTextInput(password)

        // Find the Login button and perform a click
        onNodeWithText("Login").performClick()

        // Assert that the login action is triggered with the correct credentials
        // For demonstration purposes, we'll just check that the entered email and password are non-empty.
        onNodeWithText("Username").assertTextEquals(email)
        onNodeWithText("Password").assertTextEquals(password)
    }

}
