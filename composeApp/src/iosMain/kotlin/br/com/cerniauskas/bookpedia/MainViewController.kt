package br.com.cerniauskas.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import br.com.cerniauskas.bookpedia.app.App
import br.com.cerniauskas.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }