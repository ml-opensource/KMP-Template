package presentation.feature.home

import domain.model.Product

data class HomeScreenState(
    val productList: List<Product> = emptyList(),
    val favoriteList: List<Product> = emptyList(),
    val isLoading: Boolean = false,
) {
    // Needed for SwiftUI
    constructor() : this(
        productList = emptyList(),
        favoriteList = emptyList(),
        isLoading = false
    )
}

sealed class HomeScreenIntent {
    data object OnLaunch : HomeScreenIntent()

    data class OnFavoriteClick(val product: Product) : HomeScreenIntent()
}
