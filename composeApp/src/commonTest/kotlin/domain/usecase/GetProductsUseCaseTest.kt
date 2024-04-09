package domain.usecase

import domain.model.ProductList
import domain.usecase.product.GetProductsUseCase
import fakes.FakeDataSource
import fakes.FakeProductRepository
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetProductsUseCaseTest {
    private lateinit var sut: GetProductsUseCase

    @Test
    fun `invoke returns Success`() = runTest {
        // Arrange
        sut = GetProductsUseCase(FakeProductRepository(true))
        val assertedResponse = FakeDataSource.productList

        // Act
        lateinit var actualResponse: ProductList
        sut().collect { result -> result.onSuccess { actualResponse = it } }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }

    @Test
    fun `invoke returns Failure`() = runTest {
        // Arrange
        sut = GetProductsUseCase(FakeProductRepository(false))
        val assertedResponse = "No Data"

        // Act
        lateinit var actualResponse: String
        sut().collect { result -> result.onFailure { actualResponse = it.message.toString() } }

        // Assert
        assertEquals(assertedResponse, actualResponse)
    }
}
