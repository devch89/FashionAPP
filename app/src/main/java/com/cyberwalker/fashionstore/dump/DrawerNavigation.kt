package com.cyberwalker.fashionstore.dump

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cyberwalker.fashionstore.R
import com.cyberwalker.fashionstore.navigation.Screen

sealed class DrawerScreens(val title: String, var screen_route: String) {
    object Home : DrawerScreens("Home", Screen.Home.route)
    object Search : DrawerScreens("Search",Screen.Search.route)
    object Liked : DrawerScreens( "Liked", Screen.Liked.route)
    object Profile : DrawerScreens( "Profile", Screen.Profile.route)
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Search,
    DrawerScreens.Liked,
    DrawerScreens.Profile
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    navController: NavController,
    onDestinationClicked: (route: String) -> Unit,
    isDark: Boolean = isSystemInDarkTheme()) {
        Column(
            modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 48.dp)
        ) {
            screens.forEach { screen ->
                Spacer(Modifier.height(24.dp))
                Text(
                    text = screen.title,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.clickable {
                        onDestinationClicked(screen.screen_route)
                    }
                )
            }
        }
}
