package br.com.cerniauskas.bookpedia.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchedBookDto ( // key,title,language,cover_i,author_key,author_name,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count
    @SerialName("key") val id: String,
    @SerialName("title") val title: String,
    @SerialName("language") val languages: List<String>? = null,
    @SerialName("cover_i") val coverAlternativeKey: Int? = null,
    @SerialName("author_key") val authorKeys: List<String>? = null,
    @SerialName("author_name") val authorNames: List<String>? = null,
    @SerialName("cover_edition_key") val coverKey: String? = null,
    @SerialName("first_publish_year") val firstPublishYear: Int? = null,
    @SerialName("ratings_average") val ratingsAverage: Double? = null,
    @SerialName("ratings_count") val ratingsCount: Int? = null,
    @SerialName("number_of_pages_median") val numberOfPagesMedian: Int? = null,
    @SerialName("edition_count") val numEditions: Int? = null,
)