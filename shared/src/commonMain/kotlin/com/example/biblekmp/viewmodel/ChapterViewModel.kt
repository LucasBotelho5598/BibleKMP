package com.example.biblekmp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

import com.example.biblekmp.model.Chapter
import com.example.biblekmp.services.BibleApi
import kotlinx.coroutines.launch
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.core.annotation.KoinViewModel



class ChapterViewModel(private val bibleApi: BibleApi, savedStateHandle: SavedStateHandle): ViewModel() {

    private val _chapterState = mutableStateOf(BibleStateChapter())
    val uiState: State<BibleStateChapter> = _chapterState

    private val bookId: String = savedStateHandle.get<String>("bookId")!!

    init{
        getChapterList()
    }

    fun getChapterList(){
        viewModelScope.launch{
            _chapterState.value = _chapterState.value.copy(chapter = emptyList())
            try{
                val chapter = bibleApi.getChapterList(bookId)
                _chapterState.value = _chapterState.value.copy(chapter = chapter)
            }catch(_: Exception){
                _chapterState.value = _chapterState.value.copy(chapter = emptyList())

            }
        }
    }

}


data class BibleStateChapter(
    val chapter: List<Chapter> = emptyList(),
)

