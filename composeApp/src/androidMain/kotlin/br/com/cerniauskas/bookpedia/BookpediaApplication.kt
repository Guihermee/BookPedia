package br.com.cerniauskas.bookpedia

import android.app.Application
import br.com.cerniauskas.bookpedia.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookpediaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookpediaApplication)
        }
    }
}