package com.cc.cardscampaignscompose.Screens.Entrance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cc.cardscampaignscompose.Animations.FlipActionScreen
import com.cc.cardscampaignscompose.CCApp
import com.cc.cardscampaignscompose.Components.HeadingTextComponent
import com.cc.cardscampaignscompose.R
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen
import com.cc.cardscampaignscompose.navigations.SystemBackButtonHandler

@Composable
fun TermsAndConditionScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)
    ) {

        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
        FlipActionScreen()
    }
        SystemBackButtonHandler {
            CCAppRouter.navigateTo(Screen.SignUpScreen)
        }
}
/*
@Preview
@Composable
fun TermsAndConditionScreenPreview(){
    TermsAndCondition()
}

 */