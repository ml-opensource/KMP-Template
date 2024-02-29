package data.repository

import data.model.ProductsResponse
import data.model.toDomainModel
import data.network.ApiService
import domain.repository.ProductRepository
import io.ktor.client.call.body

class ProductRepositoryImpl(private val apiService: ApiService) : ProductRepository {
    override suspend fun getProducts() =
        apiService.getProducts().body<ProductsResponse>().toDomainModel()
}
