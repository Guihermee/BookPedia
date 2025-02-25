package br.com.cerniauskas.bookpedia.book.presentation.book_list

import br.com.cerniauskas.bookpedia.core.presentation.UiText
import br.com.cerniauskas.bookpedia.book.domain.Book

data class BookListState (
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedIndex: Int = 0,
    val errorMessage: UiText? = null
)
