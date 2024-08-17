package com.cc.cardscampaignscompose.Screens.HomePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cc.cardscampaignscompose.Components.ButtonComponent
import com.cc.cardscampaignscompose.Components.LazyColumnWithMultiHeaderScreenComponents
import com.cc.cardscampaignscompose.Components.NormalTextComponent
import com.cc.cardscampaignscompose.data.SignUpViewModel
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen

@Composable
fun HomeScreen(loginViewModel: SignUpViewModel) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            NormalTextComponent(value = "Lütfen Kullandığınız Kredi Kartlarını seçin")

               ButtonComponent(value = "Çıkış", onButtonClicked = {
                    loginViewModel.logOut()

                },
                    isEnabled = true)


            LazyColumnWithMultiHeaderScreenComponents(modifier = Modifier.fillMaxWidth())

    }}
}
@Preview
@Composable
fun PreviewHomeScren(){
    HomeScreen(loginViewModel=SignUpViewModel() )
}