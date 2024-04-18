package di.modules

import data.repository.AuthRepositoryImpl
import data.repository.FavoriteRepositoryImpl
import data.repository.ProductPagingSource
import data.repository.ProductRepositoryImpl
import domain.repository.AuthRepository
import domain.repository.FavoriteRepository
import domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { ProductPagingSource(get()) }
    factory<ProductRepository> { ProductRepositoryImpl(get()) }
    factory<AuthRepository> { AuthRepositoryImpl(get()) }
    factory<FavoriteRepository> { FavoriteRepositoryImpl(get()) }
}
