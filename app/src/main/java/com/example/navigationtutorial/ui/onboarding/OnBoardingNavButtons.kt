package com.example.navigationtutorial.ui.onboarding

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navigationtutorial.ui.common.CommonButton
import com.example.navigationtutorial.ui.common.CommonTextButton
import com.example.navigationtutorial.ui.navgraph.Routes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingNavButtons(
    modifier: Modifier,
    pagerState: PagerState,
    navController: NavHostController,
) {
    val scope = rememberCoroutineScope()
    Row(
        modifier = modifier.padding(start = 10.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        CommonTextButton(
            modifier = modifier,
            text = buttonState.value[0],
            onClick = {
                if (pagerState.currentPage >= 0) {
                    scope.launch {
                        val prevPage = pagerState.currentPage - 1
                        pagerState.scrollToPage(prevPage)
                    }
                }
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        CommonButton(
            modifier = modifier,
            text = buttonState.value[1],
            onClick = {
                if (pagerState.currentPage != 2) {
                    scope.launch {
                        val nextPage = pagerState.currentPage + 1
                        pagerState.scrollToPage(nextPage)
                    }
                }
                else {
                    navController.popBackStack()
                    navController.navigate(Routes.WELCOME_SCREEN)
                }
            }
        )
    }
}