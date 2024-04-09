package domain.usecase.product

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {
    @NativeCoroutines
    suspend operator fun invoke() = runCatching { repository.getProducts() }
}
