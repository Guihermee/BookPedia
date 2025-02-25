package br.com.cerniauskas.bookpedia.book.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DescriptionDto(
    val value: String
)