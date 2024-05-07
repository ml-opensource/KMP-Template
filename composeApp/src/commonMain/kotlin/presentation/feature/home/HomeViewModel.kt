package presentation.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Product
import domain.usecase.favorite.AddToFavoriteUseCase
import domain.usecase.favorite.GetFavoritesUseCase
import domain.usecase.favorite.RemoveFromFavoriteUseCase
import domain.usecase.product.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val removeFromFavoriteUseCase: RemoveFromFavoriteUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.OnLaunch -> {
                viewModelScope.launch {
                    getFavorites()
                    getProducts()
                }
            }

            is HomeScreenIntent.OnFavoriteClick -> {
                val favoriteList = state.value.favoriteList

                if (favoriteList.contains(intent.product)) {
                    removeFromFavorite(intent.product)
                } else {
                    addToFavorite(intent.product)
                }
            }
        }
    }

    private suspend fun getFavorites() {
        _state.update { it.copy(isLoading = true) }
        getFavoritesUseCase()
            .onSuccess { response ->
                _state.update { it.copy(favoriteList = response) }
            }
            .onFailure {
                // handle error
            }
        _state.update { it.copy(isLoading = false) }
    }

    private suspend fun getProducts() {
        _state.update { it.copy(isLoading = true) }
        getProductsUseCase()
            .onSuccess { response ->
                _state.update { it.copy(productList = response.products) }
            }
            .onFailure {
                // handle error
            }
        _state.update { it.copy(isLoading = false) }
    }

    private fun addToFavorite(product: Product) {
        viewModelScope.launch {
            addToFavoriteUseCase(product)
                .onSuccess { getFavorites() }
                .onFailure {
                    // handle error
                }
        }
    }

    private fun removeFromFavorite(product: Product) {
        viewModelScope.launch {
            removeFromFavoriteUseCase(product)
                .onSuccess { getFavorites() }
                .onFailure {
                    // handle error
                }
        }
    }
}
