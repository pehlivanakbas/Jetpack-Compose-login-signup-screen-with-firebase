package com.cc.cardscampaignscompose.data

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.cc.cardscampaignscompose.R

data class LoginUIState (
    var email: String = "",
    var password: String = "",
    var emailError: Boolean = false,
    var passwordError: Boolean = false

)