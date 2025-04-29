package com.example.myapplication.ui.compose.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    selectedAgeRange: String = "--",
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )

    ) {
        (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0f)
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
                            painterResource(R.drawable.femaleicon),
                        )
                        Spacer(Modifier.width(10.dp))
                        GenderOption(
                            painterResource(R.drawable.maleicon),
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
                                .clickable { }
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                text = selectedAgeRange,
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
                        isEnabled = true
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
    isEnabled: Boolean
) {
    Button(
        onClick = {  },
        modifier = modifier
            .height(30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isEnabled)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(6.dp)
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
) {
    Card (
        colors = CardDefaults.cardColors(containerColor = white),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
    ) {
        Box(
            modifier = Modifier
                .size(50.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}

enum class Gender {
    Male, Female
}

@Preview
@Composable
fun CustomGenderAgeDialogPreview() {
    HomeWorkTheme {
        CustomGenderAgeDialog(
            onDismissRequest = {},
        )
    }
}