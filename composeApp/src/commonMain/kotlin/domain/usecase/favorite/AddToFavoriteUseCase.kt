package domain.usecase.favorite

import domain.model.Product
import domain.repository.FavoriteRepository

class AddToFavoriteUseCase(private val repository: FavoriteRepository) {

    suspend operator fun invoke(product: Product) =
        runCatching { repository.addToFavorite(product) }
}
