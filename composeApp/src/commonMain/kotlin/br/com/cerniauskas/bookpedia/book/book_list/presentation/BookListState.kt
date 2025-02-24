package br.com.cerniauskas.bookpedia.book.book_list.presentation

import br.com.cerniauskas.bookpedia.core.presentation.UiText
import br.com.cerniauskas.bookpedia.book.book_list.domain.Book

data class BookListState (
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedIndex: Int = 0,
    val errorMessage: UiText? = null
)
