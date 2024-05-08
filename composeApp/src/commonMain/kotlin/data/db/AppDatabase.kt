package data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import domain.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
