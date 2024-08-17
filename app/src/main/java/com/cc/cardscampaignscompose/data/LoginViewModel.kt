package com.cc.cardscampaignscompose.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName
    var loginUIState = mutableStateOf(LoginUIState())
    val allvalidationPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)


    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.emailChanged -> {
                loginUIState.value = loginUIState.value.copy(email = event.email)
            }


            is LoginUIEvent.passWordChanged -> loginUIState.value =
                loginUIState.value.copy(password = event.password)

            is LoginUIEvent.loginButtonClicked -> {

                login()
            }
        }
        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val emailResult =
            com.cc.cardscampaignscompose.data.rules.Validator.validateEmail(email = loginUIState.value.email)
        val passwordResult =
            com.cc.cardscampaignscompose.data.rules.Validator.validatePassword(password = loginUIState.value.password)


        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,

            )
        if (emailResult.status && passwordResult.status) {
            allvalidationPassed.value = true
        } else {
            allvalidationPassed.value = false
        }
    }

    private fun login() {
        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside Login Success")
                Log.d(TAG, "${it.isSuccessful}")
                if (it.isSuccessful) {
                    CCAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside Login Failure")
                Log.d(TAG, it.localizedMessage)
                loginInProgress.value = false


            }
    }
}