package presentation.feature.pagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import domain.usecase.GetPaginatedProductsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PaginatedHomeViewModel : ViewModel(), KoinComponent {
    private val getPaginatedProductsUseCase: GetPaginatedProductsUseCase by inject()

    val productList = getPaginatedProductsUseCase().cachedIn(viewModelScope)
}
