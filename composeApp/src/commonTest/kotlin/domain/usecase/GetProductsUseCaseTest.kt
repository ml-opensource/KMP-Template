package domain.usecase

import domain.model.Product
import domain.model.ProductList
import domain.repository.ProductRepository
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GetProductsUseCaseTest {
    private lateinit var sut: GetProductsUseCase

    @BeforeTest
    fun setup() {
        sut = GetProductsUseCase(MockProductRepository())
    }

    @Test
    fun `getProducts returns Success`() = runTest {
        // Arrange
        val response = DataSource.productList

        // Act
        lateinit var result: ProductList
        sut().collect { result = it }

        // Assert
        assertEquals(response, result)
    }
}

private class MockProductRepository : ProductRepository {
    override suspend fun getProducts() = DataSource.productList
}

private object DataSource {
    val productList = ProductList(
        products = listOf(
            Product(
                id = 1,
                title = "iPhone 9",
                description = "An apple mobile which is nothing like apple",
                price = 549,
                discountPercentage = 12.96,
                rating = 4.69,
                stock = 94,
                brand = "Apple",
                category = "smartphones",
                thumbnail = "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
                images = listOf(
                    "https://cdn.dummyjson.com/product-images/1/1.jpg",
                    "https://cdn.dummyjson.com/product-images/1/2.jpg",
                    "https://cdn.dummyjson.com/product-images/1/3.jpg",
                    "https://cdn.dummyjson.com/product-images/1/4.jpg",
                    "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
                ),
            ),
        ),
        limit = 30,
        skip = 0,
        total = 100,
    )
}
