package domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

data class ProductList(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int,
)

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String,
)
