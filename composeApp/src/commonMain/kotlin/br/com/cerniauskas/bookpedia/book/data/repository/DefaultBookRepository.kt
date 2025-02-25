package br.com.cerniauskas.bookpedia.book.data.repository

import androidx.sqlite.SQLiteException
import br.com.cerniauskas.bookpedia.book.data.database.FavoriteBookDao
import br.com.cerniauskas.bookpedia.book.data.mappers.toBook
import br.com.cerniauskas.bookpedia.book.data.mappers.toBookEntity
import br.com.cerniauskas.bookpedia.book.data.network.RemoteBookDataSource
import br.com.cerniauskas.bookpedia.book.domain.Book
import br.com.cerniauskas.bookpedia.book.domain.BookRepository
import br.com.cerniauskas.bookpedia.core.domain.DataError
import br.com.cerniauskas.bookpedia.core.domain.EmptyResult
import br.com.cerniauskas.bookpedia.core.domain.Result
import br.com.cerniauskas.bookpedia.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBookById(bookId)

        return if (localResult == null) {
            remoteBookDataSource
                .getBookDescription(bookId)
                .map { it.description ?: "" }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntity ->
                bookEntity.map { book ->
                    book.toBook()
                }
            }

    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntity ->
                bookEntity.any { it.id == id}
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBookById(id)
    }
}