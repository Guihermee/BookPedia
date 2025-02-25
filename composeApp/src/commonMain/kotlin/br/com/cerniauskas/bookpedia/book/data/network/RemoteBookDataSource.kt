package br.com.cerniauskas.bookpedia.book.data.network

import br.com.cerniauskas.bookpedia.book.data.dto.BookWorkDto
import br.com.cerniauskas.bookpedia.book.data.dto.SearchResponseDto
import br.com.cerniauskas.bookpedia.core.domain.DataError
import br.com.cerniauskas.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDescription(bookWorkId: String): Result<BookWorkDto, DataError>
}