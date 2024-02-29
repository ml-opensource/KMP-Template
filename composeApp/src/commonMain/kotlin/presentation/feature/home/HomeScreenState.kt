package presentation.feature.home

import domain.model.Product

data class HomeScreenState(
    val productList: List<Product> = emptyList(),
    val isLoading: Boolean = false
)
