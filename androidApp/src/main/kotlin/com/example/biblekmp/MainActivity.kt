package com.example.biblekmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.biblekmp.model.Verse
import com.example.biblekmp.navigation.BibleNavigation

import com.example.biblekmp.view.BookList
import com.example.biblekmp.view.ChapterList
import com.example.biblekmp.view.MainVerse



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BibleNavigation()
            //NavigationBarExample()
            //MainVerse()
            //BookList()
            //ChapterList()

        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    BibleNavigation()
    //NavigationBarExample()
    //MainVerse()
    //Verse()
    //Verse()
    //BookList()
    //ChapterList()

}