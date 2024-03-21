package com.example.navigationtutorial.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import com.example.navigationtutorial.ui.common.CommonButton
import com.example.navigationtutorial.ui.common.CommonText
import com.example.navigationtutorial.ui.common.CommonTextButton
import com.example.navigationtutorial.ui.navgraph.Routes

@Composable
fun WelcomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onLoginClicked: () -> Unit
) {
    Surface(
        modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.weight(0.05f))

            TextButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Routes.ON_BOARDING_SCREEN)
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = "back"
                )
            }

            Spacer(modifier = Modifier.weight(0.04f))

            CommonText(
                modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                textValue = "Welcome to UpTodo",
                textSize = 32.sp,
                fontWeight = FontWeight(700),
                lineHeight = 38.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                colorValue = colorResource(id = R.color.display_small),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.padding(24.dp))

            CommonText(
                modifier = Modifier.padding(horizontal = 20.dp),
                textValue = "Please login to your account or create new account to continue",
                textSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 24.sp,
                colorValue = colorResource(id = R.color.text_medium),
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.weight(0.8f))

            Column(
                modifier = modifier
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                CommonButton(
                    modifier = modifier.fillMaxWidth(),
                    text = "LOGIN",
                    onClick = onLoginClicked
                )

                Spacer(modifier = Modifier.padding(8.dp))

                CommonTextButton(
                    modifier = modifier.fillMaxWidth()
                        .border(2.dp, color = MaterialTheme.colorScheme.primary),
                    text = "CREATE ACCOUNT",
                    onClick = {
                    }
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }

}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController(), onLoginClicked = {})
}