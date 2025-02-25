package br.com.cerniauskas.bookpedia.book.presentation.book_detail

import br.com.cerniauskas.bookpedia.book.domain.Book

sealed interface BookDetailAction {
    data object onBackCLick: BookDetailAction
    data object onFavoriteClick: BookDetailAction
    data class onSelectedBookChange(val book: Book): BookDetailAction
}