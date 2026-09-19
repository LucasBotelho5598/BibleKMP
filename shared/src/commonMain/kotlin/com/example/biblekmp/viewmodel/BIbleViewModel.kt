package com.example.biblekmp.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biblekmp.model.Bible
import com.example.biblekmp.services.BibleApi
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import com.example.biblekmp.model.BibleResponse

class BibleViewModel(private val bibleapi: BibleApi): ViewModel() {

    private val _uiState = mutableStateOf(BibleState())
    val uiState: State<BibleState> = _uiState

    init{
        getBookList()
    }

    fun getBookList(){
        viewModelScope.launch{
            _uiState.value = _uiState.value.copy(bibles = emptyList())
            try{
                val bibles = bibleapi.getBooksList()
                _uiState.value = _uiState.value.copy(bibles = bibles)
            }catch(_: Exception){
                _uiState.value = _uiState.value.copy(bibles = emptyList())
            }
        }
    }
}


data class BibleState(
    val bibles: List<Bible> = emptyList(),
)