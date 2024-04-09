package di.modules

import domain.usecase.LoginUseCase
import domain.usecase.favorite.AddToFavoriteUseCase
import domain.usecase.favorite.GetFavoritesUseCase
import domain.usecase.favorite.RemoveFromFavoriteUseCase
import domain.usecase.product.GetPaginatedProductsUseCase
import domain.usecase.product.GetProductsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPaginatedProductsUseCase(get()) }
    factory { GetProductsUseCase(get()) }
    factory { GetFavoritesUseCase(get()) }
    factory { AddToFavoriteUseCase(get()) }
    factory { RemoveFromFavoriteUseCase(get()) }
    factory { LoginUseCase(get()) }
}
