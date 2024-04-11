package presentation.feature.pagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import domain.usecase.GetPaginatedProductsUseCase

class PaginatedHomeViewModel(
    getPaginatedProductsUseCase: GetPaginatedProductsUseCase,
) : ViewModel() {

    val productList = getPaginatedProductsUseCase().cachedIn(viewModelScope)
}
