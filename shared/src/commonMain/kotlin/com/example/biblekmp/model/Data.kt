package com.example.biblekmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("id")
    val id: String,
    //@SerialName("orgId")
    //val orgId: String,
    @SerialName("bibleId")
    val bibleId: String,
    @SerialName("bookId")
    val bookId: String,
    //@SerialName("number")
    //val number: String,
    @SerialName("content")
    val content: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("reference")
    val reference: String,
    @SerialName("verseCount")
    val verseCount: Int
)