package br.com.cerniauskas.bookpedia.book.book_list.domain

import br.com.cerniauskas.bookpedia.core.domain.DataError
import br.com.cerniauskas.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}