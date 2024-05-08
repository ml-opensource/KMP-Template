package data.db


import domain.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ProductDatabaseDataSource(
    private val dbRef: AppDatabase,
    private val ioDispatcher: CoroutineDispatcher,
) : ProductDataSource {
    override suspend fun insertProduct(product: Product) = withContext(ioDispatcher) {
        dbRef.productDao().insert(product = product)
    }

    override suspend fun fetchAllProducts() = withContext(ioDispatcher) {
        dbRef.productDao().getAll()
    }

    override suspend fun deleteProduct(productId: Product) = withContext(ioDispatcher) {
        dbRef.productDao().delete(productId)
    }
}
