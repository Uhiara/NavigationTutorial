package com.example.navigationtutorial.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.navigationtutorial.R


@Composable
fun CommonText(
    modifier: Modifier,
    textValue: String,
    textSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight,
    fontFamily: FontFamily,
    textAlign: TextAlign,
    colorValue: Color = Color.Black
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = textValue,
        fontSize = textSize,
        lineHeight = lineHeight,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        textAlign = textAlign,
        color = colorValue,
    )
}

@Preview
@Composable
fun CommonTextPreview() {
    CommonText(
        modifier = Modifier.fillMaxWidth(),
        textValue = "Manage your tasks",
        textSize = 32.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight(400),
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        textAlign = TextAlign.Center,
    )
}
