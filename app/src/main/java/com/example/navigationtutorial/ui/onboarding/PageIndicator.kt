package com.example.navigationtutorial.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.navigationtutorial.R
import com.example.navigationtutorial.ui.theme.Gray


@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier,
    selectedColor: Color = if (isSystemInDarkTheme()) Color.White else colorResource(id = R.color.text_button),
    unselectedColor: Color = Gray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { page ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .height(3.dp)
                    .width(40.dp)
                    .padding(start = 5.dp, end = 5.dp)
                    .background(color = if (page == currentPage) selectedColor else unselectedColor)
            )
        }
    }
}