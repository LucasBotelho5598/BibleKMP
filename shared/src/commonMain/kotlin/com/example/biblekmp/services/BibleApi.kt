package com.example.biblekmp.services

import androidx.compose.ui.graphics.Color
import com.example.biblekmp.model.Bible

import com.example.biblekmp.model.BibleResponse
import com.example.biblekmp.model.Chapter
import com.example.biblekmp.model.ChapterResponse
import com.example.biblekmp.model.Verse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.ContentType.Text.Html
import io.ktor.http.ContentType.Text.TYPE
import io.ktor.http.contentType
import io.ktor.utils.io.ioDispatcher
import kotlinx.coroutines.*

import kotlinx.coroutines.flow.*
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Singleton



class BibleApi(private val client: HttpClient) {

     suspend fun getBooksList(): List<Bible> {
        return (client.get("https://rest.api.bible/v1/bibles/65eec8e0b60e656b-01/books") {
        }.body() as BibleResponse).data
    }


     suspend fun getChapterList(bookId: String): List<Chapter> {
        return (client.get("https://rest.api.bible/v1/bibles/65eec8e0b60e656b-01/books/${bookId}/chapters") {
        }.body() as ChapterResponse).data
    }

     suspend fun getChapter(id: String): Verse {
        return (client.get("https://rest.api.bible/v1/bibles/65eec8e0b60e656b-01/chapters/${id}") {
            url {
                parameters.append("content-type", "text")
                parameters.append("include-titles", "true")
                //parameters.append("include-verse-spans", "true")
                //parameters.append("include-notes", "true")
            }
        }).body()
    }

}