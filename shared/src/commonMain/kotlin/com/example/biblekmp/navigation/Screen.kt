package com.example.biblekmp.navigation

sealed class Screen(
    val route: String
) {

    data object Home: Screen("Home")

    data object ChapterList: Screen(
        route = "{bookId}/chapters"
    ){
        fun createRoute(bookId: String) = "${bookId}/chapters"
    }

    data object Verse: Screen(
        route = "chapters/{id}"
    ){
        fun createRoute(id: String) = "chapters/${id}"
    }

}