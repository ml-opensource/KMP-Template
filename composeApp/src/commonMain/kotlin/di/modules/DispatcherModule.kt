package di.modules

import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

val dispatcherModule = module {
    single(named(Dispatcher.IO)) { Dispatchers.IO }
    single(named(Dispatcher.MAIN)) { Dispatchers.Main }
    single(named(Dispatcher.DEFAULT)) { Dispatchers.Default }
    single(named(Dispatcher.UNCONFINED)) { Dispatchers.Unconfined }
}

enum class Dispatcher {
    IO,
    MAIN,
    DEFAULT,
    UNCONFINED,
}
