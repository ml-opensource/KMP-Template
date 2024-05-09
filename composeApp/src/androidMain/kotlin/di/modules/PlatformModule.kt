package di.modules

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.db.AppDatabase
import data.db.DataBaseConstants.DATABASE_NAME
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import java.io.File

actual val platformModule = module {
    single<AppDatabase> { createRoomDatabase(get()) }
}

fun createRoomDatabase(ctx: Context): AppDatabase {
    val dbFile = ctx.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<AppDatabase>(ctx, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
