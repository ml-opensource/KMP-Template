package di

import data.network.ApiService
import data.network.ApiServiceImpl
import data.repository.AuthRepositoryImpl
import data.repository.ProductPagingSource
import data.repository.ProductRepositoryImpl
import di.modules.dataPersistenceModule
import di.modules.dispatcherModule
import di.modules.mapperModule
import di.modules.networkModule
import di.modules.platformModule
import di.modules.repositoryModule
import di.modules.useCaseModule
import domain.repository.AuthRepository
import domain.repository.ProductRepository
import domain.usecase.LoginUseCase
import domain.usecase.product.GetPaginatedProductsUseCase
import domain.usecase.product.GetProductsUseCase
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.feature.home.HomeViewModel
import presentation.feature.login.LoginViewModel
import presentation.feature.pagination.PaginatedHomeViewModel

object Modules {


    val services = module {
        single<ApiService> { ApiServiceImpl(get()) }
    }

    val repositories = module {
        factory<ProductRepository> { ProductRepositoryImpl(get()) }
        factory<AuthRepository> { AuthRepositoryImpl(get()) }
        factory { ProductPagingSource(get()) }
    }

    val useCases = module {
        factory { GetProductsUseCase(get()) }
        factory { GetPaginatedProductsUseCase(get()) }
        factory { LoginUseCase(get()) }
    }

    val viewModels = module {
        factory { LoginViewModel(get()) }
        factory { HomeViewModel(get(), get(), get(), get()) }
        factory { PaginatedHomeViewModel(get(), get()) }
    }
}

fun initKoin(
    appModule: Module = module { },
    servicesModule: Module = Modules.services,
    repositoriesModule: Module = Modules.repositories,
    useCasesModule: Module = Modules.useCases,
    viewModels: Module = Modules.viewModels,
): KoinApplication = startKoin {
    modules(
        appModule,
        mapperModule,
        networkModule,
        dispatcherModule,
        servicesModule,
        repositoriesModule,
        useCasesModule,
        viewModels,
        dataPersistenceModule,
        repositoryModule,
        useCaseModule,
        platformModule
    )
}
