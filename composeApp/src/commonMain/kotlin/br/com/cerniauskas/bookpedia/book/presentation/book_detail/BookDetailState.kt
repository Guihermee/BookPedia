package br.com.cerniauskas.bookpedia.book.presentation.book_detail

import br.com.cerniauskas.bookpedia.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)