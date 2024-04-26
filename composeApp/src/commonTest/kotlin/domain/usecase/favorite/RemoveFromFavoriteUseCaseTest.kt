package domain.usecase.favorite

import fakes.FakeDataSource
import fakes.FakeFavoriteRepository
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class RemoveFromFavoriteUseCaseTest {
    private lateinit var sut: RemoveFromFavoriteUseCase

    @Test
    fun `invoke returns Success`() = runTest {
        // Arrange
        sut = RemoveFromFavoriteUseCase(FakeFavoriteRepository(true))
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
        sut = RemoveFromFavoriteUseCase(FakeFavoriteRepository(false))
        val assertedResponse = "Error"

        // Act
        lateinit var actualResponse: String
        sut(FakeDataSource.product).onFailure { actualResponse = it.message.toString() }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }
}
