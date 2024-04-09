package di.modules

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.monstarlab.kmp.ProductDatabase
import data.db.DataBaseConstants.DATABASE_NAME
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(ProductDatabase.Schema, get(), DATABASE_NAME)
    }
}
