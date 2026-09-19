package com.example.biblekmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Chapter(
    @SerialName("id")
    val id: String,
    @SerialName("bibleId")
    val bibleId : String,
    @SerialName("number")
    val number: String,
    @SerialName("bookId")
    val bookId: String

)
