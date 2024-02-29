package presentation.feature.home

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : KMMViewModel(), KoinComponent {
    private val getProductsUseCase: GetProductsUseCase by inject()
    private val _state = MutableStateFlow(viewModelScope, HomeScreenState())

    @NativeCoroutinesState
    val state = _state.asStateFlow()

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.OnLoadMore -> getProducts()
        }
    }

    private fun getProducts() {
        viewModelScope.coroutineScope.launch {
            getProductsUseCase()
                .onStart { _state.update { it.copy(isLoading = true) } }
                .onCompletion { _state.update { it.copy(isLoading = false) } }
                .collect { response ->
                    _state.update { it.copy(productList = response.products) }
                }
        }
    }
}
