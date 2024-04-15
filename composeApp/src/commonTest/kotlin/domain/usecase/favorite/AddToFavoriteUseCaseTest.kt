package domain.usecase.favorite

import fakes.FakeDataSource
import fakes.FakeFavoriteRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AddToFavoriteUseCaseTest {
    private lateinit var sut: AddToFavoriteUseCase

    @Test
    fun `invoke returns Success`() = runTest {
        // Arrange
        sut = AddToFavoriteUseCase(FakeFavoriteRepository(true))
        val assertedResponse = Unit

        // Act
        lateinit var actualResponse: Unit
        sut(FakeDataSource.product).onSuccess { actualResponse = it }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }

    @Test
    fun `invoke returns Failure`() = runTest {
        // Arrange
        sut = AddToFavoriteUseCase(FakeFavoriteRepository(false))
        val assertedResponse = "Error"

        // Act
        lateinit var actualResponse: String
        sut(FakeDataSource.product).onFailure { actualResponse = it.message.toString() }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }
}
