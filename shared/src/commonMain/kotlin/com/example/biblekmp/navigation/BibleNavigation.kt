package com.example.biblekmp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biblekmp.model.Bible
import com.example.biblekmp.model.ChapterResponse
import com.example.biblekmp.view.BookList
import com.example.biblekmp.view.ChapterList
import com.example.biblekmp.view.MainVerse
import com.example.biblekmp.viewmodel.BibleViewModel
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun BibleNavigation(
    //navController: NavHostController = rememberNavController(),
) {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Screen.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(
            Screen.Home.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition={
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )

            }

            ) {

            BookList(onClickBook = {
                navController.navigate(Screen.ChapterList.createRoute(bookId = it.id))
            })

        }
        composable(Screen.ChapterList.route,
            enterTransition = {
            fadeIn(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
            exitTransition={
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )

            }) {

            ChapterList(onClickChapter = {
                navController.navigate(Screen.Verse.createRoute(id = it.id))
            })
        }

        composable(Screen.Verse.route) {
            MainVerse()
        }
    }
}