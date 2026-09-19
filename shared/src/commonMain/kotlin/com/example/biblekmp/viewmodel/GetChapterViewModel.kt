package com.example.biblekmp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biblekmp.model.Verse
import com.example.biblekmp.services.BibleApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


sealed interface VerseUiState{
    data object Loading: VerseUiState
    data class Success(val verse: Verse): VerseUiState
}

class GetChapterViewModel(private val bibleApi: BibleApi, savedStateHandle: SavedStateHandle): ViewModel() {

    private val _uiState = MutableStateFlow<VerseUiState>(VerseUiState.Loading)
    val uiState: StateFlow<VerseUiState> = _uiState.asStateFlow()

    private val id: String = savedStateHandle.get<String>("id")!!



/*
    val uiState: StateFlow<VerseUiState> = bibleApi.getVerse().map(VerseUiState::Success).stateIn(
        viewModelScope,
        initialValue = VerseUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )

 */

    init{
        viewModelScope.launch{
            val verse = bibleApi.getChapter(id)
            _uiState.value = VerseUiState.Success(verse)
        }
    }






    //private val _verseState = MutableStateFlow<Verse?>(null)
    //val uiState: StateFlow<Verse?> = _verseState.asStateFlow()



    }
