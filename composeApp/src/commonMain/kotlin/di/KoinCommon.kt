package di

import di.modules.dataPersistenceModule
import di.modules.dispatcherModule
import di.modules.mapperModule
import di.modules.networkModule
import di.modules.platformModule
import di.modules.repositoryModule
import di.modules.useCaseModule
import di.modules.viewModelsModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module


fun initKoin(appModule: Module = module { }): KoinApplication = startKoin {
    modules(
        appModule,
        mapperModule,
        dispatcherModule,
        networkModule,
        dataPersistenceModule,
        repositoryModule,
        useCaseModule,
        platformModule,
        viewModelsModule
    )
}