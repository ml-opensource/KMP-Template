package di

import di.modules.databaseModule
import di.modules.mapperModule
import di.modules.networkModule
import di.modules.platformModule
import di.modules.repositoryModule
import di.modules.useCaseModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module = module { }): KoinApplication = startKoin {
    modules(
        appModule,
        mapperModule,
        networkModule,
        databaseModule,
        repositoryModule,
        useCaseModule,
        platformModule
    )
}
