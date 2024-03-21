package com.example.navigationtutorial.ui.navgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationtutorial.R
import com.example.navigationtutorial.ui.onboarding.OnBoardingScreen
import com.example.navigationtutorial.ui.onboarding.SplashScreen
import com.example.navigationtutorial.ui.screens.CalenderScreen
import com.example.navigationtutorial.ui.screens.FocusScreen
import com.example.navigationtutorial.ui.screens.IndexScreen
import com.example.navigationtutorial.ui.screens.ProfileScreen
import com.example.navigationtutorial.ui.screens.WelcomeScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Index")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.clock),
                            contentDescription = ""
                        )
                    }
                },
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Color.Green
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navController.popBackStack()
                        navController.navigate(Routes.INDEX)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.DateRange
                        navController.popBackStack()
                        navController.navigate(Routes.CALENDER)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = "Calender",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.DateRange) Color.White else Color.DarkGray
                    )
                }

                LargeFloatingActionButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 5.dp),
                    onClick = { },
                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation()
                ) {
                    Icon(Icons.Filled.Add, "Large floating action button")
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Lock
                        navController.popBackStack()
                        navController.navigate(Routes.FOCUS)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Lock) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.AccountCircle
                        navController.popBackStack()
                        navController.navigate(Routes.PROFILE)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.AccountCircle) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.SPLASH_SCREEN,
            modifier = Modifier.padding(it)
        ) {

            composable(Routes.SPLASH_SCREEN) {
                SplashScreen(navController)
            }

            composable(Routes.ON_BOARDING_SCREEN) {
                OnBoardingScreen(navController)
            }

            composable(Routes.WELCOME_SCREEN) {
                WelcomeScreen(navController)
            }

            composable(Routes.INDEX) {
                IndexScreen()
            }

            composable(Routes.CALENDER) {
                CalenderScreen()
            }

            composable(Routes.FOCUS) {
                FocusScreen()
            }

            composable(Routes.PROFILE) {
                ProfileScreen()
            }
        }
    }
}