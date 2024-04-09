package di.modules

import data.mapper.ProductDBMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ProductDBMapper() }
}
