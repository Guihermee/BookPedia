package br.com.cerniauskas.bookpedia.book.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteBookDao {

    @Upsert
    suspend fun upsert(book: BookEntity)

    @Query("SELECT * FROM bookentity")
    fun getFavoriteBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM bookentity WHERE id = :id")
    suspend fun getFavoriteBookById(id: String): BookEntity?

    @Query("DELETE FROM bookentity WHERE id = :id")
    suspend fun deleteFavoriteBookById(id: String)

}