package com.cc.cardscampaignscompose.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cc.cardscampaignscompose.R
import com.cc.cardscampaignscompose.data.CardsDatas

val cardlist = listOf(
    CardsDatas(
        cardType = "Visa",
        userName = "Fettah BAŞAK",
        balance = 12L,
      //  color = getGradient(Color.Yellow, Color.LightGray),
        background = R.drawable.maximumplatinium
    ),
    CardsDatas(
        cardType = "MasterCard",
        userName = "Fettah BAŞAK",
        balance = 12L,
      //  color = getGradient(Color.Red, Color.LightGray),
        background = R.drawable.maximum_aidatsiz_kart
    ),

    CardsDatas(
        cardType = "Edenred",
        userName = "Fettah BAŞAK",
        balance = 12L,
      //  color = getGradient(Color.Blue, Color.Black),
        background = R.drawable.maximum_pati_kart)

)



@Preview
@Composable
fun GetCardSection() {
    LazyRow {
        items(cardlist.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cardlist[index]
    var lastItemPaddingEnd = 0.dp

    if (index == cardlist.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 12.dp, end = lastItemPaddingEnd)) {
        Image(painter = painterResource(card.background), contentDescription = "maximumplatinium")
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .width(250.dp)
            .height(160.dp)
            .clickable { }
            .padding(vertical = 5.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {



        }
    }
}



