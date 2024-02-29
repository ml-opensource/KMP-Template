package domain.repository

import domain.model.ProductList

interface ProductRepository {
    suspend fun getProducts(): ProductList
}
