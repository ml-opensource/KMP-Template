package domain.usecase.favorite

import domain.model.Product
import fakes.FakeDataSource
import fakes.FakeFavoriteRepository
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GetFavoritesUseCaseTest {
    private lateinit var sut: GetFavoritesUseCase

    @Test
    fun `invoke returns Success`() = runTest {
        // Arrange
        sut = GetFavoritesUseCase(FakeFavoriteRepository(true))
        val assertedResponse = listOf(FakeDataSource.product)

        // Act
        lateinit var actualResponse: List<Product>
        sut().onSuccess { actualResponse = it }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }

    @Test
    fun `invoke returns Failure`() = runTest {
        // Arrange
        sut = GetFavoritesUseCase(FakeFavoriteRepository(false))
        val assertedResponse = "Error"

        // Act
        lateinit var actualResponse: String
        sut().onFailure { actualResponse = it.message.toString() }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }
}
