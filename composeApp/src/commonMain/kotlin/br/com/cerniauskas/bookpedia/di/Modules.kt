package br.com.cerniauskas.bookpedia.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import br.com.cerniauskas.bookpedia.book.data.database.DatabaseFactory
import br.com.cerniauskas.bookpedia.book.data.database.FavoriteBookDatabase
import br.com.cerniauskas.bookpedia.book.data.network.KtorRemoteBookDataSource
import br.com.cerniauskas.bookpedia.book.data.network.RemoteBookDataSource
import br.com.cerniauskas.bookpedia.book.data.repository.DefaultBookRepository
import br.com.cerniauskas.bookpedia.book.domain.BookRepository
import br.com.cerniauskas.bookpedia.book.presentation.SelectedBookViewModel
import br.com.cerniauskas.bookpedia.book.presentation.book_detail.BookDetailViewModel
import br.com.cerniauskas.bookpedia.book.presentation.book_list.BookListViewModel
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

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao}

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}