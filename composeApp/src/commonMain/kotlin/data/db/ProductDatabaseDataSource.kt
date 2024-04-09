package data.db

import com.monstarlab.kmp.ProductDatabase
import data.mapper.ProductDBMapper
import domain.model.Product

class ProductDatabaseDataSource(
    private val dbRef: ProductDatabase,
    private val mapper: ProductDBMapper
) : ProductDataSource {
    override fun insertProduct(product: Product) =
        dbRef.productQueries.insertProduct(mapper.mapToDatabaseModel(product))

    override fun fetchAllProducts() =
        dbRef.productQueries
            .selectAll()
            .executeAsList()
            .map { mapper.mapToDomainModel(it) }

    override fun deleteProduct(productId: Int) =
        dbRef.productQueries.deleteProduct(productId.toLong())
}
