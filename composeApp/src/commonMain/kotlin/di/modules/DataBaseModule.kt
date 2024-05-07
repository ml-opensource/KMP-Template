package di.modules

import data.db.ProductDataSource
import data.db.ProductDatabaseDataSource
import data.preference.createDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataPersistenceModule = module {
    single<ProductDataSource> { ProductDatabaseDataSource(get(), get(named(Dispatcher.IO))) }
    single { createDataStore() }
}
