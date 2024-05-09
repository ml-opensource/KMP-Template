package di.modules

import org.koin.dsl.module
import presentation.feature.home.HomeViewModel
import presentation.feature.login.LoginViewModel
import presentation.feature.pagination.PaginatedHomeViewModel
import presentation.feature.splash.SplashViewModel

val viewModelsModule = module {
    factory { SplashViewModel(get()) }
    factory { LoginViewModel(get(), get()) }
    factory { HomeViewModel(get(), get(), get(), get()) }
    factory { PaginatedHomeViewModel(get()) }
}
