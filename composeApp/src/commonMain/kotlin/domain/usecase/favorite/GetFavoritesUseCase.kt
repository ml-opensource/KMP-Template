package domain.usecase.favorite

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import domain.repository.FavoriteRepository

class GetFavoritesUseCase(private val repository: FavoriteRepository) {
    @NativeCoroutines
    suspend operator fun invoke() = runCatching { repository.getFavorites() }
}
