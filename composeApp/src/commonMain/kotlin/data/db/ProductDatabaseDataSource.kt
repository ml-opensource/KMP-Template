package data.db

import com.monstarlab.kmp.ProductDatabase
import data.mapper.ProductDBMapper
import domain.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ProductDatabaseDataSource(
    private val dbRef: ProductDatabase,
    private val ioDispatcher: CoroutineDispatcher,
    private val mapper: ProductDBMapper,
) : ProductDataSource {
    override suspend fun insertProduct(product: Product) = withContext(ioDispatcher) {
        dbRef.productQueries.insertProduct(mapper.mapToDatabaseModel(product))
    }

    override suspend fun fetchAllProducts() = withContext(ioDispatcher) {
        dbRef.productQueries
            .selectAll()
            .executeAsList()
            .map { mapper.mapToDomainModel(it) }
    }

    override suspend fun deleteProduct(productId: Int) = withContext(ioDispatcher) {
        dbRef.productQueries.deleteProduct(productId.toLong())
    }
}
