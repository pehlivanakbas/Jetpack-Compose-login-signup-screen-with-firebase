package com.cc.cardscampaignscompose

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cc.cardscampaignscompose.Screens.HomePage.HomeScreen
import com.cc.cardscampaignscompose.Screens.Entrance.LoginScreen
import com.cc.cardscampaignscompose.Screens.Entrance.SignUpScreen
import com.cc.cardscampaignscompose.Screens.Entrance.TermsAndConditionScreen
import com.cc.cardscampaignscompose.Screens.HomePage.CardsAndCampaignsScreen
import com.cc.cardscampaignscompose.data.LoginViewModel
import com.cc.cardscampaignscompose.data.SignUpViewModel
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen

@Composable
fun CCApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Crossfade(targetState = CCAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionScreen -> {
                    TermsAndConditionScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen(loginViewModel = LoginViewModel())
                }

                is Screen.FlipCard -> {
                    Screen.FlipCard
                }

                is Screen.HomeScreen -> {
                    HomeScreen(loginViewModel = SignUpViewModel())
                }


                Screen.SplashScreen -> TODO()
                is Screen.CardsAndCampaignsScreen -> {
                    CardsAndCampaignsScreen()
                }
            }

        }
    }
}