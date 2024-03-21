package com.example.navigationtutorial.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
import com.example.navigationtutorial.ui.common.CommonImage
import com.example.navigationtutorial.ui.common.CommonText
import com.example.navigationtutorial.ui.common.CommonTextButton
import com.example.navigationtutorial.ui.navgraph.Routes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val images = listOf(
        R.drawable.onboarding1,
        R.drawable.onboarding2,
        R.drawable.onboarding3,
    )

    val titles = listOf(
        "Manage your tasks",
        "Create daily routine",
        "Organize your tasks",
    )

    val descriptions = listOf(
        "You can easily manage all of your daily tasks in DoMe for free",
        "In Uptodo  you can create your personalized routine to stay productive",
        "You can organize your daily tasks by adding your tasks into separate categories",
    )

    val pagerState = rememberPagerState(
        pageCount = images.size
    )

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            Spacer(modifier = Modifier.weight(0.1f))

            CommonTextButton(
                modifier = modifier.padding(start = 10.dp),
                text = "Skip",
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Routes.WELCOME_SCREEN)
                }
            )

            HorizontalPager(
                state = pagerState,
                modifier = modifier.fillMaxSize()
            ) { currentPage ->
                Column(
                    Modifier.fillMaxSize(),
                ) {

                    CommonImage(imageValue = images[currentPage])

                    Spacer(modifier = Modifier.weight(0.3f))

                    PageIndicator(
                        pageCount = images.size,
                        currentPage = pagerState.currentPage,
                        modifier = modifier.fillMaxWidth(),
                    )

                    Spacer(modifier = Modifier.weight(0.3f))

                    CommonText(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        textValue = titles[currentPage],
                        textSize = 32.sp,
                        lineHeight = 38.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        colorValue = colorResource(id = R.color.display_small),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.weight(0.3f))

                    CommonText(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        textValue = descriptions[currentPage],
                        textSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        colorValue = colorResource(id = R.color.text_medium),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .navigationBarsPadding(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OnBoardingNavButtons(
                            modifier = modifier,
                            pagerState = pagerState,
                            navController = navController
                        )
                    }

                    Spacer(modifier = Modifier.weight(0.2f))
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(
        rememberNavController(),
        modifier = Modifier,
    )
}