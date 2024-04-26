package presentation.feature.home

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModelProvider: KoinComponent {
    private val viewModel by inject<HomeViewModel>()
    fun provide() = viewModel
}