package di.modules

import org.koin.dsl.module
import presentation.feature.home.HomeViewModel
import presentation.feature.login.LoginViewModel
import presentation.feature.pagination.PaginatedHomeViewModel

val viewModelsModule = module {
    factory { LoginViewModel(get()) }
    factory { HomeViewModel(get(), get(), get(), get()) }
    factory { PaginatedHomeViewModel(get(), get()) }
}