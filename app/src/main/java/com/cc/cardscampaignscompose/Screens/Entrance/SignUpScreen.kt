package com.cc.cardscampaignscompose.Screens.Entrance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cc.cardscampaignscompose.Components.ButtonComponent
import com.cc.cardscampaignscompose.Components.CheckBoxComponent
import com.cc.cardscampaignscompose.Components.ClickableLoginTextComponent
import com.cc.cardscampaignscompose.Components.DividerTextCompoent
import com.cc.cardscampaignscompose.Components.HeadingTextComponent
import com.cc.cardscampaignscompose.Components.MyTextField
import com.cc.cardscampaignscompose.Components.NormalTextComponent
import com.cc.cardscampaignscompose.Components.PassWordTextFieldComponent
import com.cc.cardscampaignscompose.R
import com.cc.cardscampaignscompose.data.SignUpViewModel
import com.cc.cardscampaignscompose.data.SignUpUIEvent
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen

@Composable
fun SignUpScreen(loginviewModel: SignUpViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
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
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(
                    labelValue = stringResource(id = R.string.first_name),
                    Icons.Filled.Person,
                    onTextSelected = {
                        loginviewModel.onEvent(SignUpUIEvent.FirstNameChanged(it))
                    }, loginviewModel.registrationUIState.value.firstNameError
                )
                MyTextField(
                    labelValue = stringResource(id = R.string.last_name),
                    Icons.Filled.Person,
                    onTextSelected = {
                        loginviewModel.onEvent(SignUpUIEvent.LastNameChanged(it))

                    }, loginviewModel.registrationUIState.value.lastNameError
                )
                MyTextField(
                    labelValue = stringResource(id = R.string.e_mail),
                    Icons.Filled.Email,
                    onTextSelected = {
                        loginviewModel.onEvent(SignUpUIEvent.emailChanged(it))
                    }, errorStatus = loginviewModel.registrationUIState.value.emailError
                )
                PassWordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    Icons.Filled.Lock,
                    onTextSelected = {
                        loginviewModel.onEvent(SignUpUIEvent.passWordChanged(it))
                    },
                    loginviewModel.registrationUIState.value.passwordError
                )
                CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected = {
                        CCAppRouter.navigateTo(Screen.TermsAndConditionScreen)
                    },
                    onCheckedChange = {
                        loginviewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    })
                Spacer(modifier = Modifier.height(80.dp))
                //button Component kotrol et
                ButtonComponent(
                    value = stringResource(id = R.string.signup),
                    onButtonClicked = { loginviewModel.onEvent(SignUpUIEvent.RegisterButtonClicked) },
                    isEnabled = loginviewModel.allvalidationPassed.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextCompoent()
                ClickableLoginTextComponent(true, onTextSelected = {
                    CCAppRouter.navigateTo(Screen.LoginScreen)
                })


            }

        }
        if(loginviewModel.signUpInProgress.value){
            CircularProgressIndicator()

        }
    }

}

@Preview
@Composable
fun DefaulPreviewOfSignUpScreen() {
    SignUpScreen()
}

