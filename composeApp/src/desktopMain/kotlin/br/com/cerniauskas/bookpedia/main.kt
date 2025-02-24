package br.com.cerniauskas.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.cerniauskas.bookpedia.app.App
import br.com.cerniauskas.bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookPedia",
        ) {
            App()
        }
    }
}