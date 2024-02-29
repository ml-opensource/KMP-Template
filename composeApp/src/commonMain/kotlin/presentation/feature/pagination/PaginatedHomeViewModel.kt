package presentation.feature.pagination

import androidx.paging.cachedIn
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import domain.usecase.GetProductsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PaginatedHomeViewModel : KMMViewModel(), KoinComponent {
    private val getProductsUseCase: GetProductsUseCase by inject()

    val productList = getProductsUseCase().cachedIn(viewModelScope.coroutineScope)
}
