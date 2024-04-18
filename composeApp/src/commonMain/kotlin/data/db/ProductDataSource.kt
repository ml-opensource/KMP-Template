package data.db

import domain.model.Product

interface ProductDataSource {
    suspend fun insertProduct(product: Product)

    suspend fun fetchAllProducts(): List<Product>

    suspend fun deleteProduct(productId: Int)
}
