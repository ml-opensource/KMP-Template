package domain.usecase

import app.cash.paging.Pager
import app.cash.paging.PagingConfig
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import data.repository.ProductPagingSource
import domain.model.Product
import domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetProductsUseCase(
    private val repository: ProductRepository,
    private val pagingSource: ProductPagingSource
) {
    // Paginated products
    private val pager: Pager<Int, Product> = run {
        val pagingConfig = PagingConfig(pageSize = 10, initialLoadSize = 10)
        check(pagingConfig.pageSize == pagingConfig.initialLoadSize) {
            "An elegant PagingSource implementation requires each page to be of equal size."
        }
        Pager(pagingConfig) { pagingSource }
    }

    operator fun invoke() = pager.flow

    // Non-Paginated products
    @NativeCoroutines
    fun getProducts() = flow { emit(repository.getProducts()) }.flowOn(Dispatchers.Default)
}
