package br.com.cerniauskas.bookpedia.book.presentation.book_list

import br.com.cerniauskas.bookpedia.book.domain.Book

sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}