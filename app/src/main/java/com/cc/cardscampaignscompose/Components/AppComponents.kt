package com.cc.cardscampaignscompose.Components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalGasStation
import androidx.compose.material.icons.rounded.MonitorHeart
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.common.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cc.cardscampaignscompose.Dummy.CategoryofCampaigns

import com.cc.cardscampaignscompose.R
import com.cc.cardscampaignscompose.Screens.HomePage.CardsAndCampaignsScreen
import com.cc.cardscampaignscompose.data.BottomNavigation
import com.cc.cardscampaignscompose.data.CardsDatas
import com.cc.cardscampaignscompose.data.retrieveCampaigns
import com.cc.cardscampaignscompose.data.rules.itemList
import com.cc.cardscampaignscompose.ui.theme.colorGrey
import com.cc.cardscampaignscompose.ui.theme.colorPrimary
import com.cc.cardscampaignscompose.ui.theme.colorSecondary
import com.cc.cardscampaignscompose.ui.theme.componentShapes

fun getGradient(startColor: Color, endColor: Color):  Brush{
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}
@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(), style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.color_text), textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp), style = TextStyle(
            fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.color_text), textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    labelValue: String,
    vector: ImageVector,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val textvalue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .clip(componentShapes.small),

        label = { Text(text = labelValue) }, colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary
        ), keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
        ), singleLine = true, maxLines = 1, value = textvalue.value, onValueChange = {
            textvalue.value = it
            onTextSelected(it)
        }, isError = !errorStatus, leadingIcon = {
            androidx.compose.material3.Icon(imageVector = vector, contentDescription = "")


        })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassWordTextFieldComponent(
    labelValue: String,
    vector: ImageVector,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),

        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorPrimary,
            cursorColor = colorPrimary
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
        ),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions { localFocusManager.clearFocus() },
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)

        },
        leadingIcon = {
            androidx.compose.material3.Icon(imageVector = vector, contentDescription = "")
        },

        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icon(
                    painter = painterResource(id = R.drawable.visible_icon),
                    contentDescription = "visible"
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.invisible_icon),
                    contentDescription = "iinvisible"
                )
            }
            var description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(
                    painter = painterResource(id = R.drawable.visible_icon),
                    contentDescription = description
                )
            }


        },
        isError = !errorStatus,

        visualTransformation = if (passwordVisible.value) VisualTransformation.None else {
            PasswordVisualTransformation()

        }

    )
}


@Composable
fun CheckBoxComponent(
    value: String, onTextSelected: (String) -> Unit, onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
            onCheckedChange.invoke(it)
        })
        // NormalTextComponent(value)
        ClickableTextComponent(value = value, onTextSelected)

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By contiuning you accept our "
    val privacyPolicyText = " Privacy Policy "
    val andText = " and "
    val termsAndConditionsText = " Terms of Use "
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->
        if (offset != null) {
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("Clickable Component", "{$span}")
                if (span.item == termsAndConditionsText || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)

                }
            }
        }
    })
}


@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        onClick = { onButtonClicked.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(colorSecondary, colorPrimary)),
                    shape = RoundedCornerShape(50.dp)
                ), contentAlignment = Alignment.Center
        ) {
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DividerTextCompoent() {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorGrey, thickness = 1.dp,
        )

        Text(
            modifier = Modifier.padding(3.dp),
            text = stringResource(id = R.string.or),
            fontSize = 14.sp,
            color = colorGrey
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = colorGrey, thickness = 2.dp
        )
    }
}


@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if (tryingToLogin) {
        "Zaten Üye misiniz "
    } else {
        "Üye Değilim."
    }

    val loginText = if (tryingToLogin) {
        "Giriş yap"

    } else {
        " Kayıt ol"
    }

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .heightIn(), style = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center
    ), text = annotatedString, onClick = { offset ->
        if (offset != null) {
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("Clickable Component", "{$span}")
                if (span.item == loginText || (span.item == loginText)) {
                    onTextSelected(span.item)

                }
            }
        }
    })
}

@Composable
fun UnderlinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorgrey),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}


//HOMEPAGE
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnWithMultiHeaderScreenComponents(
    modifier: Modifier
) {

    // a mutable map variable , which indicate that item is visible or not
    var isShow = remember {
        mutableStateMapOf<String, Boolean>()
    }

    // by default we will store true , all the item will be visible
    LaunchedEffect(key1 = Unit) {
        isShow = isShow.apply {
            itemList.associate { item ->
                item.type to true
            }.also {
                putAll(it)
            }
        }
    }

    LazyColumn(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        val groupItems = itemList.groupBy { it.type }
        groupItems.forEach { (type, items) ->
            item {
                Row(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .fillMaxWidth()
                        .toggleable(
                            value = isShow[type] == true, onValueChange = {
                                isShow[type] = it
                            }, role = Role.Button
                        )
                ) {
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = type,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                color = Color.Black, fontWeight = FontWeight.W700
                            ),

                            )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "(${items.size})",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                color = Color.Black,
                            ),

                            )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        if (isShow[type] == true) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                        contentDescription = null,
                        modifier = Modifier.align(CenterVertically)
                    )
                }
            }
            if (isShow[type] == true) items(items, key = { it.id }) {

                Text(
                    text = it.name, style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Red
                    ), modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }

}

@Composable
fun GetBottomNavigationBar() {
    val items = listOf(
        BottomNavigation(
            title = "Anasayfa", icon = Icons.Rounded.Home
        ), BottomNavigation(
            title = "Kartlarım", icon = Icons.Rounded.Wallet
        ), BottomNavigation(
            title = "Bildirimler", icon = Icons.Rounded.Notifications
        ), BottomNavigation(
            title = "Hesap", icon = Icons.Rounded.AccountCircle
        )
    )

    NavigationBar {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(selected = index == 0, onClick = { /*TODO*/ }, icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }, label = {
                    Text(
                        text = item.title, color = MaterialTheme.colorScheme.onBackground
                    )
                })
            }
        }
    }
}

@Composable
fun GetWalletSection() {
    Row(
        modifier = Modifier
            .background(
                getGradient(
                    colorResource(id = R.color.colorSecondary),
                    colorResource(id = R.color.color_primary)
                )
            )
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(bottom = 1.dp),
                text = "Sayın",
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(bottom = 1.dp),
                text = "Fettah Başak",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )


        }
        Icon(
            modifier = Modifier
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(25))
                .clickable {},
        imageVector = Icons.Rounded.Search,
        contentDescription = "Search",
        tint = MaterialTheme.colorScheme.onSecondaryContainer,

        )

    }
}

@Composable
fun GetCategoriesSection() {
    val categoriesList = listOf(
        CategoryofCampaigns(
            icon = (R.drawable.gas_station), "Akaryakıt"
        ), CategoryofCampaigns(
            icon = (R.drawable.shopping), "Alışveriş"
        ), CategoryofCampaigns(
            icon = (R.drawable.health_icon_two), "Sağlık"
        ), CategoryofCampaigns(
            icon = (R.drawable.travel_image), "Seyahat"
        )
    )
    Column {
        Text(
            text = "Kategoriler",
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()

            
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow {
            items(categoriesList.size) {
                CategoriesItem(it)

            }
        }
    }
}

@Preview
@Composable
fun CategoriesItem(index: Int) {

    val categoriesList = listOf(
        CategoryofCampaigns(
            icon = (R.drawable.education_image), "Eğitim"
        ), CategoryofCampaigns(
            icon = (R.drawable.shopping), "Alışveriş"
        ), CategoryofCampaigns(
            icon = (R.drawable.health_icon_two), "Sağlık"
        ), CategoryofCampaigns(
            icon = (R.drawable.travel_image), "Seyahat"
        )
    )

    val categories = categoriesList[index]
    var lastPaddingEnd = 0.dp
    if (index == categoriesList.size - 1) {
        lastPaddingEnd = 16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(colorResource(id = R.color.glassmorphism))
            .size(105.dp)
            .shadow(2.dp, RoundedCornerShape(1.dp))
            .clickable { }
            .padding(1.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .shadow(elevation = 1.dp, RoundedCornerShape(1.dp))
                    .height(80.dp),
                painter = painterResource(id = categories.icon),
                contentDescription = categories.name,
                alignment = Alignment.TopStart,


                )

            Text(
                text = categories.name,
                //color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetCampanyListSection() {
    val campaignsList = retrieveCampaigns()
    val myContext = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(count = campaignsList.count(), itemContent = { index ->
            val campaigns = campaignsList[index]

            //CARD
            Card(
                onClick = {
                    Toast.makeText(
                        myContext,
                        "you selected the ${campaigns.campaignName}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .fillParentMaxWidth()
                    .height(90.dp)
                    .shadow(elevation = 2.dp, RoundedCornerShape(2.dp))
                    .padding(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = (colorResource(id = R.color.glassmorphism))
                ),


                ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(7.dp),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = CenterVertically) {
                        Image(
                            painter = painterResource(id = campaigns.campaignImage),
                            contentDescription = campaigns.campaignName,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(100))
                                .shadow(elevation = 4.dp, ambientColor = Color.Magenta),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = campaigns.campaignName,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = campaigns.campaignDetail,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }

                    }

                }
            }
        })
    }

}

@Composable
fun PreviewCCScren() {
    GetCampanyListSection()
}




