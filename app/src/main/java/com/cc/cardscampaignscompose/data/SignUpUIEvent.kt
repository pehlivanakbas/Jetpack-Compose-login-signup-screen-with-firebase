package com.cc.cardscampaignscompose.data

sealed class SignUpUIEvent {
    data class FirstNameChanged(val firstName: String) : SignUpUIEvent()
    data class LastNameChanged(val lastName: String) : SignUpUIEvent()
    data class emailChanged(val email: String) : SignUpUIEvent()
    data class passWordChanged(val password: String) : SignUpUIEvent()

    data class PrivacyPolicyCheckBoxClicked(val status: Boolean) : SignUpUIEvent()
    object RegisterButtonClicked : SignUpUIEvent()


}
