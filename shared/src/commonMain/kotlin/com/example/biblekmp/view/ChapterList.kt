package com.example.biblekmp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SegmentedButtonDefaults.borderStroke
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biblekmp.model.Bible
import com.example.biblekmp.model.Chapter
import com.example.biblekmp.viewmodel.BibleViewModel
import com.example.biblekmp.viewmodel.ChapterViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ChapterList(onClickChapter:(Chapter) -> Unit={}){
    val viewModel = koinViewModel<ChapterViewModel>()
    val state by remember{viewModel.uiState}
    //val uiState by viewModel.uiState.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.statusBarsPadding()

    ) {
        items(state.chapter, key = {it.id}) { chapter: Chapter ->
                TextButton(onClick = { onClickChapter(chapter) },
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Black)
                ) {
                    Text(chapter.number, fontSize = 18.sp, color = Color.White)
                }


        }
    }
}