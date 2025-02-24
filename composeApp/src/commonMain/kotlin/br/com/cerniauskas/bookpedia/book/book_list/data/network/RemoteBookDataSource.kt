package br.com.cerniauskas.bookpedia.book.book_list.data.network

import br.com.cerniauskas.bookpedia.book.book_list.data.dto.SearchResponseDto
import br.com.cerniauskas.bookpedia.core.domain.DataError
import br.com.cerniauskas.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}