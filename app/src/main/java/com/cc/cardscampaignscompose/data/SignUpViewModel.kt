package com.cc.cardscampaignscompose.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignUpViewModel : ViewModel() {
    private val TAG = SignUpViewModel::class.java.simpleName
    var registrationUIState = mutableStateOf(RegistrationUIState())
    val allvalidationPassed = mutableStateOf(false)
    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignUpUIEvent) {
        validateDataWithRules()

        when (event) {
            is SignUpUIEvent.FirstNameChanged -> {
                registrationUIState.value =
                    registrationUIState.value.copy(firstName = event.firstName)
                printState()

                //yenileme yaparsa bu fonksiyonu tekrardan çağıracak
            }

            is SignUpUIEvent.LastNameChanged -> {
                registrationUIState.value =
                    registrationUIState.value.copy(lastName = event.lastName)
                printState()
            }

            is SignUpUIEvent.emailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(email = event.email)
                printState()
            }

            is SignUpUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value =
                    registrationUIState.value.copy(privacyPolicyAccepted = event.status)
            }

            is SignUpUIEvent.passWordChanged -> {
                registrationUIState.value =
                    registrationUIState.value.copy(password = event.password)
                printState()
            }

            is SignUpUIEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(TAG, "Inside printState")
        printState()
        // validateDataWithRules()
        createUSerInFireBase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun validateDataWithRules() {
        val fNameResult = com.cc.cardscampaignscompose.data.rules.Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )
        val lNameResult =
            com.cc.cardscampaignscompose.data.rules.Validator.validateLastName(lName = registrationUIState.value.lastName)

        val emailResult =
            com.cc.cardscampaignscompose.data.rules.Validator.validateEmail(email = registrationUIState.value.email)
        val passwordResult =
            com.cc.cardscampaignscompose.data.rules.Validator.validatePassword(password = registrationUIState.value.password)
        val privacyPolicyResult =
            com.cc.cardscampaignscompose.data.rules.Validator.validatePrivacyPolicyAcceptance(
                statusValue = registrationUIState.value.privacyPolicyAccepted
            )


        Log.d(TAG, "Inside validateDataWithRules")
        Log.d(TAG, " fNameResult ${fNameResult}")
        Log.d(TAG, "lNameResult ${lNameResult}")
        Log.d(TAG, "emailResult ${emailResult}")
        Log.d(TAG, "passwordResult ${passwordResult}")
        Log.d(TAG, "privacypocliyResult ${privacyPolicyResult}")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status

        )
        //bütün değerler doğrulandığında buton enable olması için ->
        if (fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && privacyPolicyResult.status) {
            allvalidationPassed.value = true
        } else {
            allvalidationPassed.value = false
        }
    }

    private fun printState() {
        Log.d(TAG, "Inside printState")
        Log.d(TAG, registrationUIState.value.toString())

    }

    private fun createUSerInFireBase(email: String, password: String) {
        signUpInProgress.value = true
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "is Succesfull= ${it.isSuccessful}")
                if (it.isSuccessful) {
                    signUpInProgress.value = false
                    CCAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Insıde_OnFailureListener")
                Log.d(TAG, "Exception => ${it.message}")
                Log.d(TAG, "Exception =>  ${it.localizedMessage}")

            }
    }


    fun logOut() {
        val fireBaseAuth = FirebaseAuth.getInstance()
        fireBaseAuth.signOut()
        val authStateListener=AuthStateListener{
            if(it.currentUser==null){
            Log.d(TAG,"Inside sign out Success")
                CCAppRouter.navigateTo(Screen.LoginScreen)
            }
            else{
                Log.d(TAG,"Inside sign out is Not Complete")

            }

        }
            fireBaseAuth.addAuthStateListener(authStateListener)
    }
}