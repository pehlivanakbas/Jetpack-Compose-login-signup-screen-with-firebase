package com.cc.cardscampaignscompose.navigations

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object SignUpScreen:Screen()
    object TermsAndConditionScreen:Screen()
    object LoginScreen:Screen()
    object FlipCard:Screen()
    object SplashScreen:Screen()
    object HomeScreen:Screen()
    object CardsAndCampaignsScreen:Screen()


}

object CCAppRouter{
    val currentScreen:MutableState<Screen> = mutableStateOf(Screen.HomeScreen)
    fun navigateTo(destination:Screen){
        currentScreen.value=destination
    }
}