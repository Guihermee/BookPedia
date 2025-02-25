package br.com.cerniauskas.bookpedia.book.presentation

import androidx.lifecycle.ViewModel
import br.com.cerniauskas.bookpedia.book.domain.Book
import br.com.cerniauskas.bookpedia.book.presentation.book_list.BookListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel : ViewModel() {

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: Book?) {
        _selectedBook.value = book
    }

}