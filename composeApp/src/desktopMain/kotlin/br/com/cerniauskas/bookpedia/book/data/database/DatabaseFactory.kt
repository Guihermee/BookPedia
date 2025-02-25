package br.com.cerniauskas.bookpedia.book.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.cerniauskas.bookpedia.book.data.database.FavoriteBookDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "BookPedia")
            os.contains("mac") -> File(userHome, "Library/Application Support/BookPedia")
            else -> File(userHome, ".local/share/BookPedia")
        }

        if (!appDataDir.exists()) {
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, FavoriteBookDatabase.DATABASE_NAME)

        return Room.databaseBuilder(dbFile.absolutePath)
    }
}