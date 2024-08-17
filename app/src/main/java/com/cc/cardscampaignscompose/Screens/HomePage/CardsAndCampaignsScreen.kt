package com.cc.cardscampaignscompose.Screens.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cc.cardscampaignscompose.Components.GetBottomNavigationBar
import com.cc.cardscampaignscompose.Components.GetCampanyListSection
import com.cc.cardscampaignscompose.Components.GetCardSection
import com.cc.cardscampaignscompose.Components.GetCategoriesSection

import com.cc.cardscampaignscompose.Components.GetWalletSection

@Composable
fun CardsAndCampaignsScreen() {
    Scaffold(bottomBar = {
        GetBottomNavigationBar()
    }) {

            padding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(1.dp)
        )
        {
            //wallet Section
            GetWalletSection()
            Spacer(modifier = Modifier.height(10.dp))

            //Cards Section
            GetCardSection()
            GetCategoriesSection()
            GetCampanyListSection()
            //Campaigns Section
        }
    }
}


@Preview
@Composable
fun PreviewCCScren() {
    CardsAndCampaignsScreen()
}