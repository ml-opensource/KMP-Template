package data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import domain.model.Product

@Dao
interface ProductDao {

    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM Product")
    suspend fun getAll(): List<Product>

    @Query("SELECT * FROM Product WHERE id = :id")
    suspend fun getProductById(id: Long): Product?

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)
}
