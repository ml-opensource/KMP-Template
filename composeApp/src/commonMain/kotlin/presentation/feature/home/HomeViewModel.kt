package presentation.feature.home

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import domain.model.Product
import domain.usecase.favorite.AddToFavoriteUseCase
import domain.usecase.favorite.GetFavoritesUseCase
import domain.usecase.favorite.RemoveFromFavoriteUseCase
import domain.usecase.product.GetProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : KMMViewModel(), KoinComponent {
    private val getProductsUseCase: GetProductsUseCase by inject()
    private val getFavoritesUseCase: GetFavoritesUseCase by inject()
    private val addToFavoriteUseCase: AddToFavoriteUseCase by inject()
    private val removeFromFavoriteUseCase: RemoveFromFavoriteUseCase by inject()
    private val _state = MutableStateFlow(viewModelScope, HomeScreenState())

    @NativeCoroutinesState
    val state = _state.asStateFlow()

    fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.OnLaunch -> {
                viewModelScope.coroutineScope.launch {
                    getFavorites()
                    getProducts()
                }
            }

            is HomeScreenIntent.OnFavoriteClick -> {
                val favoriteList = state.value.favoriteList

                if (favoriteList.contains(intent.product))
                    removeFromFavorite(intent.product)
                else
                    addToFavorite(intent.product)
            }
        }
    }

    private suspend fun getFavorites() {
        viewModelScope.coroutineScope.launch {
            withContext(Dispatchers.IO) {
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
        }
    }

    private suspend fun getProducts() {
        viewModelScope.coroutineScope.launch {
            withContext(Dispatchers.IO) {
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
        }
    }

    private fun addToFavorite(product: Product) {
        viewModelScope.coroutineScope.launch {
            withContext(Dispatchers.IO) {
                addToFavoriteUseCase(product)
                    .onSuccess { getFavorites() }
                    .onFailure {
                        // handle error
                    }
            }
        }
    }

    private fun removeFromFavorite(product: Product) {
        viewModelScope.coroutineScope.launch {
            withContext(Dispatchers.IO) {
                removeFromFavoriteUseCase(product)
                    .onSuccess { getFavorites() }
                    .onFailure {
                        // handle error
                    }
            }
        }
    }
}
