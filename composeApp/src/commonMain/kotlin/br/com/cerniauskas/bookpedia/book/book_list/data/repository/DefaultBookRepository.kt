package br.com.cerniauskas.bookpedia.book.book_list.data.repository

import br.com.cerniauskas.bookpedia.book.book_list.data.mappers.toBook
import br.com.cerniauskas.bookpedia.book.book_list.data.network.RemoteBookDataSource
import br.com.cerniauskas.bookpedia.book.book_list.domain.Book
import br.com.cerniauskas.bookpedia.book.book_list.domain.BookRepository
import br.com.cerniauskas.bookpedia.core.domain.DataError
import br.com.cerniauskas.bookpedia.core.domain.Result
import br.com.cerniauskas.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}