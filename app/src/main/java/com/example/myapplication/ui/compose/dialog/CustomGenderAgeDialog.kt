package com.example.myapplication.ui.compose.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.example.myapplication.R
import com.example.myapplication.ui.compose.theme.HomeWorkTheme
import com.example.myapplication.ui.compose.theme.black
import com.example.myapplication.ui.compose.theme.secondaryGray
import com.example.myapplication.ui.compose.theme.white

@Composable
fun CustomGenderAgeDialog(
    username: String = "Username",
    gender: Gender?,
    age: Int?,
    changeGender: (Gender) -> Unit,
    changeAge: (Int) -> Unit,
    onContinueBtnClick: () -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )

    ) {
        (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0f)

        var expanded by remember { mutableStateOf(false) }
        val range = IntRange(16, 30)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(horizontal = 13.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = white),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center),
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.cardElevation(12.dp)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(
                        text = "Привет, $username!",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.W700,
                            fontSize = 14.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 17.dp),
                        text = "Расскажи о себе.\nЭто необходимо, чтобы подбирать партнёров за столом",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = black,
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 46.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Пол:",
                            style = TextStyle(
                                fontWeight = FontWeight.W700,
                                color = black,
                                fontSize = 14.sp
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        GenderOption(
                            painterResource(R.drawable.maleicon),
                            gender == Gender.Male,
                            Color(0xFF3DB2FE),
                            {
                                changeGender(Gender.Male)
                            }
                        )
                        Spacer(Modifier.width(10.dp))
                        GenderOption(
                            painterResource(R.drawable.femaleicon),
                            gender == Gender.Female,
                            Color(0xFFFF7BAC),
                            {
                                changeGender(Gender.Female)
                            }
                        )
                    }
                    Spacer(Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 46.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Возраст:",
                            style = TextStyle(
                                fontWeight = FontWeight.W700,
                                color = black,
                                fontSize = 14.sp
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Box(
                            modifier = Modifier
                                .background(
                                    color = Color(0xFFF2F2F2),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .width(110.dp)
                                .height(30.dp)
                                .clickable {
                                    expanded = true
                                }
                        ) {
                            DropdownMenu(
                                expanded = expanded,
                                shape = RoundedCornerShape(15.dp),
                                containerColor = Color(0xFFF2F2F2),
                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {
                                range.forEach {
                                    DropdownMenuItem(
                                        text = {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(30.dp)
                                            ) {
                                                Text(
                                                    it.toString(),
                                                    modifier = Modifier
                                                        .align(Alignment.Center),
                                                    style = if (it != age)
                                                        TextStyle(
                                                            fontWeight = FontWeight.W400,
                                                            fontSize = 16.sp,
                                                            fontStyle = FontStyle.Italic,
                                                        )
                                                    else
                                                        TextStyle(
                                                            fontWeight = FontWeight.W700,
                                                            fontSize = 16.sp,
                                                            fontStyle = FontStyle.Italic,
                                                        )
                                                )
                                                if (it == age) Icon(
                                                    painterResource(R.drawable.checkmark),
                                                    modifier = Modifier
                                                        .align(Alignment.CenterEnd)
                                                        .padding(end = 8.dp),
                                                    contentDescription = "Age Dropdown",
                                                    tint = Color.Unspecified,
                                                ) else null
                                            }
                                        },
                                        onClick = {
                                            expanded = false
                                            changeAge(it)
                                        },
                                        contentPadding = PaddingValues(0.dp),
                                    )
                                    if (it != range.last)
                                        Divider(thickness = 1.dp, color = Color.LightGray)
                                }
                            }
                            Text(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                text = if (age == null) "- -" else age.toString(),
                                style = TextStyle(
                                    fontWeight = FontWeight.W700,
                                    fontSize = 16.sp,
                                    fontStyle = FontStyle.Italic
                                )
                            )
                            Icon(
                                modifier = Modifier
                                    .padding(end = 12.dp)
                                    .height(4.5.dp)
                                    .width(12.dp)
                                    .align(Alignment.CenterEnd),
                                tint = Color(0xFFC1C1C1),
                                painter = painterResource(R.drawable.dropdown_arrow),
                                contentDescription = "Age Dropdown"
                            )

                        }
                    }
                    Spacer(Modifier.height(20.dp))
                    DialogButton(
                        isEnabled = gender != null && age != null,
                        onClick = onContinueBtnClick
                    )
                    Spacer(Modifier.height(14.dp))

                }
            }
        }

    }
}

@Composable
fun DialogButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(6.dp),
        enabled = isEnabled
    ) {
        Text(
            text = "Продолжить",
            style = TextStyle(
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = white
            )
        )
    }
}


@Composable
fun GenderOption(
    icon: Painter,
    isSelected: Boolean,
    selectedColor: Color,
    onClick: () -> Unit
) {
    val selectedBackground = selectedColor.copy(alpha = 0.20F)
    Card (
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(10.dp),
        border = if (isSelected) BorderStroke(2.dp, selectedColor) else null,
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        onClick = onClick
    ) {

        Box(
            modifier = Modifier
                .size(50.dp)
                .then(
                    if (isSelected) Modifier.background(selectedBackground)
                    else Modifier
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}

enum class Gender(val value: String) {
    Male("m"), Female("f")
}

@Preview
@Composable
fun CustomGenderAgeDialogPreview() {
    HomeWorkTheme {
        CustomGenderAgeDialog(
            "",
            Gender.Female,
            10,
            {},
            {},
            {},
            {}
        )
    }
}