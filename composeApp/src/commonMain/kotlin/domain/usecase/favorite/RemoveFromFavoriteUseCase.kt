package domain.usecase.favorite

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import domain.model.Product
import domain.repository.FavoriteRepository

class RemoveFromFavoriteUseCase(private val repository: FavoriteRepository) {
    @NativeCoroutines
    suspend operator fun invoke(product: Product) =
        runCatching { repository.removeFromFavorite(product) }
}
