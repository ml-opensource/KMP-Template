package presentation.feature.pagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import domain.usecase.GetUserFromPreferenceUseCase
import domain.usecase.User
import domain.usecase.product.GetPaginatedProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaginatedHomeViewModel(
    getPaginatedProductsUseCase: GetPaginatedProductsUseCase,
    private val userUseCase: GetUserFromPreferenceUseCase
) : ViewModel() {

    val productList = getPaginatedProductsUseCase().cachedIn(viewModelScope)
    private val _user = MutableStateFlow<User?>(null)

    init {
        getUser()
    }


    private fun getUser() = viewModelScope.launch {
        _user.emit(userUseCase.get())
    }

    fun saveUser(name: String, email: String) = viewModelScope.launch {
        val user = User(name, email)
        userUseCase.add(user)
    }
}
