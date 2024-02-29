package di

import data.network.ApiService
import data.repository.ProductPagingSource
import data.repository.ProductRepositoryImpl
import domain.repository.ProductRepository
import domain.usecase.GetProductsUseCase
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val services = module {
        single { ApiService(get()) }
    }

    val repositories = module {
        factory<ProductRepository> { ProductRepositoryImpl(get()) }
        factory { ProductPagingSource(get()) }
    }

    val useCases = module {
        factory { GetProductsUseCase(get(), get()) }
    }
}

fun initKoin(
    appModule: Module = module { },
    networkModule: Module = NetworkModule.networkClient,
    servicesModule: Module = Modules.services,
    repositoriesModule: Module = Modules.repositories,
    useCasesModule: Module = Modules.useCases
): KoinApplication = startKoin {
    modules(
        appModule,
        networkModule,
        servicesModule,
        repositoriesModule,
        useCasesModule
    )
}
