package br.com.cerniauskas.bookpedia.book.presentation.book_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cerniauskas.bookpedia.book.domain.Book
import br.com.cerniauskas.bookpedia.book.domain.BookRepository
import br.com.cerniauskas.bookpedia.core.domain.onError
import br.com.cerniauskas.bookpedia.core.domain.onSuccess
import br.com.cerniauskas.bookpedia.core.presentation.toUiText
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookListViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val cachedBooks = emptyList<Book>()
    private var searchJob: Job? = null
    private var observeFavoritesBookJob: Job? = null

    private val _state = MutableStateFlow(BookListState())
    val state = _state
        .onStart {
            if (cachedBooks.isEmpty()) {
                observeSearchQuery()
            }
            observeFavoriteBooks()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            initialValue = _state.value
        )

    fun onAction(action: BookListAction) {
        when (action) {
            is BookListAction.OnBookClick -> {

            }

            is BookListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(
                        searchQuery = action.query
                    )
                }
            }

            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(
                        selectedIndex = action.index
                    )
                }
            }
        }
    }

    private fun observeFavoriteBooks() {
        observeFavoritesBookJob?.cancel()
        observeFavoritesBookJob = bookRepository
            .getFavoriteBooks()
            .onEach { favoriteBooks ->
                _state.update {
                    it.copy(
                        favoriteBooks = favoriteBooks
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    @OptIn(FlowPreview::class)
    private fun observeSearchQuery() {
        state
            .map { it.searchQuery }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(
                                errorMessage = null,
                                searchResults = cachedBooks
                            )
                        }
                    }

                    query.length >= 2 -> {
                        searchJob?.cancel()
                        searchJob = searchBooks(query)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun searchBooks(query: String) = viewModelScope.launch {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        bookRepository
            .searchBooks(query)
            .onSuccess { searchResult ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        searchResults = searchResult,
                        errorMessage = null
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        searchResults = emptyList(),
                        errorMessage = error.toUiText()
                    )
                }
            }
    }
}