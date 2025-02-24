package br.com.cerniauskas.bookpedia.di

import br.com.cerniauskas.bookpedia.book.book_list.data.network.KtorRemoteBookDataSource
import br.com.cerniauskas.bookpedia.book.book_list.data.network.RemoteBookDataSource
import br.com.cerniauskas.bookpedia.book.book_list.data.repository.DefaultBookRepository
import br.com.cerniauskas.bookpedia.book.book_list.domain.BookRepository
import br.com.cerniauskas.bookpedia.book.book_list.presentation.BookListViewModel
import br.com.cerniauskas.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
}