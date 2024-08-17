package com.cc.cardscampaignscompose.Dummy

import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.cc.cardscampaignscompose.Components.getGradient
import com.cc.cardscampaignscompose.R
import com.cc.cardscampaignscompose.data.CardsDatas
data class CategoryofCampaigns(
    val icon:Int,
    val name: String)