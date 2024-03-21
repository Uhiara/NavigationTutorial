package com.example.navigationtutorial.ui.navgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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


@Composable
fun AppBottomBar(
    visibilityProvider: () -> Boolean,
    selectedIconProvider: () -> ImageVector,
    onBottomBarItemClicked: (routeName: String) -> Unit

) {
    val selectedIcon = selectedIconProvider()
    if (visibilityProvider()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BottomAppBar(
                modifier = Modifier.padding(top = 48.dp),
                containerColor = Color.Green
            ) {
                IconButton(
                    onClick = {
                        onBottomBarItemClicked(Routes.INDEX)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selectedIcon == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        onBottomBarItemClicked(Routes.CALENDER)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = "Calender",
                        modifier = Modifier.size(26.dp),
                        tint = if (selectedIcon == Icons.Default.DateRange) Color.White else Color.DarkGray
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(96.dp)
                )

                IconButton(
                    onClick = {
                        onBottomBarItemClicked(Routes.FOCUS)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "Focus",
                        modifier = Modifier.size(26.dp),
                        tint = if (selectedIcon == Icons.Default.Lock) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        onBottomBarItemClicked(Routes.PROFILE)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(26.dp),
                        tint = if (selectedIcon == Icons.Default.AccountCircle) Color.White else Color.DarkGray
                    )
                }
            }

            LargeFloatingActionButton(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                onClick = { },
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation()
            ) {
                Icon(Icons.Filled.Add, "Large floating action button")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    var selected by remember {
        mutableStateOf(Icons.Default.Home)
    }
    var showNavigationBars by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AppTopBar { showNavigationBars }
        },

        bottomBar = {
            AppBottomBar(
                visibilityProvider = { showNavigationBars },
                selectedIconProvider = { selected },
                onBottomBarItemClicked = { route ->
                    when (route) {
                        Routes.INDEX -> {
                            selected = Icons.Default.Home
                            navController.navigate(Routes.INDEX) {
                                popUpTo(0)
                            }
                        }

                        Routes.CALENDER -> {
                            selected = Icons.Default.DateRange
                            navController.navigate(Routes.CALENDER) {
                                popUpTo(0)
                            }
                        }

                        Routes.FOCUS -> {
                            selected = Icons.Default.Lock
                            navController.navigate(Routes.FOCUS) {
                                popUpTo(0)
                            }
                        }

                        Routes.PROFILE -> {
                            selected = Icons.Default.AccountCircle
                            navController.navigate(Routes.PROFILE) {
                                popUpTo(0)
                            }
                        }
                    }
                })
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.SPLASH_SCREEN,
            modifier = Modifier.padding(it)
        ) {

            composable(Routes.SPLASH_SCREEN) {
                showNavigationBars = false
                SplashScreen(navController)
            }

            composable(Routes.ON_BOARDING_SCREEN) {
                showNavigationBars = false
                OnBoardingScreen(navController)
            }

            composable(Routes.WELCOME_SCREEN) {
                showNavigationBars = false
                WelcomeScreen(navController, onLoginClicked = {
                    navController.navigate(Routes.INDEX) {
                        popUpTo(0)
                    }
                })
            }

            composable(Routes.INDEX) {
                showNavigationBars = true
                IndexScreen()
            }

            composable(Routes.CALENDER) {
                showNavigationBars = true
                CalenderScreen()
            }

            composable(Routes.FOCUS) {
                showNavigationBars = true
                FocusScreen()
            }

            composable(Routes.PROFILE) {
                showNavigationBars = true
                ProfileScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(visibilityProvider: () -> Boolean) {
    if (visibilityProvider()) {
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
    }
}
