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
import com.cc.cardscampaignscompose.Components.ClickableLoginTextComponent
import com.cc.cardscampaignscompose.Components.DividerTextCompoent
import com.cc.cardscampaignscompose.Components.HeadingTextComponent
import com.cc.cardscampaignscompose.Components.MyTextField
import com.cc.cardscampaignscompose.Components.NormalTextComponent
import com.cc.cardscampaignscompose.Components.PassWordTextFieldComponent
import com.cc.cardscampaignscompose.Components.UnderlinedTextComponent
import com.cc.cardscampaignscompose.R
import com.cc.cardscampaignscompose.data.LoginUIEvent
import com.cc.cardscampaignscompose.data.LoginViewModel
import com.cc.cardscampaignscompose.navigations.CCAppRouter
import com.cc.cardscampaignscompose.navigations.Screen
import com.cc.cardscampaignscompose.navigations.SystemBackButtonHandler


@Composable
fun LoginScreen(loginViewModel: LoginViewModel= viewModel()) {
    
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {

            Column (modifier = Modifier.fillMaxSize()
            ){
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComponent(value = stringResource(id = R.string.welcome_back))
                HeadingTextComponent(value = stringResource(id = R.string.login))
                Spacer(modifier = Modifier.height(70.dp))
                MyTextField(labelValue = stringResource(id = R.string.e_mail), Icons.Filled.Email, onTextSelected = {
                loginViewModel.onEvent((LoginUIEvent.emailChanged(it)))

                }, errorStatus = loginViewModel.loginUIState.value.emailError)
                Spacer(modifier = Modifier.height(20.dp))
                PassWordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    Icons.Filled.Lock,
                    onTextSelected = {loginViewModel.onEvent(LoginUIEvent.passWordChanged(it))},
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )
                Spacer(modifier = Modifier.height(20.dp))
                UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(value = stringResource(id = R.string.login), onButtonClicked ={
                loginViewModel.onEvent(LoginUIEvent.loginButtonClicked)
                } ,loginViewModel.allvalidationPassed.value)
                Spacer(modifier = Modifier.height(40.dp))
                DividerTextCompoent()
                ClickableLoginTextComponent(false, onTextSelected = {
                    CCAppRouter.navigateTo(Screen.SignUpScreen)
                })

            }
            SystemBackButtonHandler {
                CCAppRouter.navigateTo(Screen.SignUpScreen)
            }


            if(loginViewModel.loginInProgress.value){
                CircularProgressIndicator()
            }
        }
    }

}
@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(loginViewModel = LoginViewModel())
}