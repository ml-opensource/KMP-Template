package di.modules

import app.cash.sqldelight.ColumnAdapter
import com.monstarlab.kmp.ProductDB
import com.monstarlab.kmp.ProductDatabase
import data.db.ProductDataSource
import data.db.ProductDatabaseDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

val databaseModule = module {
    single {
        ProductDatabase(get(), ProductDB.Adapter(object : ColumnAdapter<List<String>, String> {
            override fun decode(databaseValue: String) =
                if (databaseValue.isEmpty()) {
                    listOf()
                } else {
                    databaseValue.split(",")
                }

            override fun encode(value: List<String>) = value.joinToString(separator = ",")
        }))
    }
    single<ProductDataSource> { ProductDatabaseDataSource(get(), get(named(Dispatcher.IO)), get()) }
}
