package di.modules

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.monstarlab.kmp.ProductDatabase
import data.db.DataBaseConstants.DATABASE_NAME
import org.koin.dsl.module

actual val platformModule = module {
    single<SqlDriver> {
        NativeSqliteDriver(ProductDatabase.Schema, DATABASE_NAME)
    }
}
