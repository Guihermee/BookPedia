package br.com.cerniauskas.bookpedia.core.presentation

import bookpedia.composeapp.generated.resources.Res
import bookpedia.composeapp.generated.resources.error_disk_full
import bookpedia.composeapp.generated.resources.error_no_internet
import bookpedia.composeapp.generated.resources.error_request_timeout
import bookpedia.composeapp.generated.resources.error_serialization
import bookpedia.composeapp.generated.resources.error_too_many_requests
import bookpedia.composeapp.generated.resources.error_unknown_error
import br.com.cerniauskas.bookpedia.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringResource = when(this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown_error
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown_error
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown_error
    }

    return UiText.StringResourceId(stringResource)
}