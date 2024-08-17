package com.cc.cardscampaignscompose.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.cc.cardscampaignscompose.R

@Composable
fun retrieveCampaigns(): SnapshotStateList<CampaignsModel> {

    val countryList = remember {
        mutableStateListOf(
            CampaignsModel(
                1, "Akaryakıt", "Akaryakıt Kampanyaları", R.drawable.gas_station
            ),
            CampaignsModel(2, "Eğitim", "Eğitim Kampanyaları", R.drawable.education_image),
            CampaignsModel(3, "Sağlık", "Sağlık kampanyaları", R.drawable.health_icon_two),
            CampaignsModel(4, "Alışveriş", "Alışveriş Kampanyaları", R.drawable.shopping),
            CampaignsModel(5, "Seyehat", "Seyehat Kampanyaları", R.drawable.travel_image),
            CampaignsModel(
                6, "Diğer", "Diğer kategori kampanyaları", R.drawable.cards
            ),
        )
    }
    return countryList
}