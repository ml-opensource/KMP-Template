package domain.usecase.favorite

import domain.repository.FavoriteRepository

class GetFavoritesUseCase(private val repository: FavoriteRepository) {

    suspend operator fun invoke() = runCatching { repository.getFavorites() }
}
