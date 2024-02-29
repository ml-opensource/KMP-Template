package presentation.feature.home

sealed class HomeScreenEvent {
    data object OnLoadMore : HomeScreenEvent()
}
