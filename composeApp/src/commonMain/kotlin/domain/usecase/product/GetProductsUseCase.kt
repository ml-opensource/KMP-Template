package domain.usecase.product


import domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {

    suspend operator fun invoke() = runCatching { repository.getProducts() }
}
