package com.example.navigationtutorial.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun CommonImage(imageValue: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.36f)
            .padding(horizontal = 30.dp),
        painter = painterResource(id = imageValue),
        contentDescription = ""
    )
}
