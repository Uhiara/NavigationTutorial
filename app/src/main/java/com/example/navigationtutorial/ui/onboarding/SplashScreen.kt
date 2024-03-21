package com.example.navigationtutorial.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationtutorial.R
import com.example.navigationtutorial.ui.common.CommonText
import com.example.navigationtutorial.ui.navgraph.Routes
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(Routes.ON_BOARDING_SCREEN)
    }
    Surface(
        modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.todo_image),
                contentDescription = "Todo image"
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            CommonText(
                modifier = modifier,
                textValue = "UpTodo",
                textSize = 40.sp,
                lineHeight = 48.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                colorValue = colorResource(id = R.color.display_small),
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}