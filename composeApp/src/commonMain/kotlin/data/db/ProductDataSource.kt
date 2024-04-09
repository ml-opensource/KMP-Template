package data.db

import domain.model.Product

interface ProductDataSource {
    fun insertProduct(product: Product)

    fun fetchAllProducts(): List<Product>

    fun deleteProduct(productId: Int)
}
