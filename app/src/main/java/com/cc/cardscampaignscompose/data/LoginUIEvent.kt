package com.cc.cardscampaignscompose.data

sealed class LoginUIEvent {
    data class emailChanged(val email: String) : LoginUIEvent()
    data class passWordChanged(val password: String) : LoginUIEvent()
    object loginButtonClicked: LoginUIEvent()
}