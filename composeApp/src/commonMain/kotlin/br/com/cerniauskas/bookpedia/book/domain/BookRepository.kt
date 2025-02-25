package br.com.cerniauskas.bookpedia.book.domain

import br.com.cerniauskas.bookpedia.core.domain.DataError
import br.com.cerniauskas.bookpedia.core.domain.EmptyResult
import br.com.cerniauskas.bookpedia.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)
}