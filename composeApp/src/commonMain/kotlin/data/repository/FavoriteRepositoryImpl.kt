package data.repository

import data.db.ProductDataSource
import domain.model.Product
import domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(private val productDataSource: ProductDataSource) :
    FavoriteRepository {
    override suspend fun getFavorites(): List<Product> = productDataSource.fetchAllProducts()

    override suspend fun addToFavorite(product: Product) = productDataSource.insertProduct(product)

    override suspend fun removeFromFavorite(product: Product) =
        productDataSource.deleteProduct(product.id)
}
