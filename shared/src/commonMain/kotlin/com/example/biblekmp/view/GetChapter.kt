package com.example.biblekmp.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.biblekmp.model.Verse
import com.example.biblekmp.viewmodel.GetChapterViewModel
import com.example.biblekmp.viewmodel.VerseUiState



import org.koin.compose.viewmodel.koinViewModel


@Composable
fun MainVerse(){
    val viewModel = koinViewModel<GetChapterViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    GetChapter(uiState)

}
@Composable
fun GetChapter(verseUiState: VerseUiState){

        when (verseUiState) {
            is VerseUiState.Success -> ContentBible(verseUiState.verse)
            else -> {}
        }
}
@Composable
fun ContentBible(verse: Verse){
        Column(
            modifier = Modifier.fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState()),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(verse.data.reference,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(12.dp))
            Text(verse.data.content,
                fontSize = 18.sp,
                overflow = TextOverflow.MiddleEllipsis,
                color = Color.Black,
                modifier = Modifier.padding(12.dp))
        }


}








