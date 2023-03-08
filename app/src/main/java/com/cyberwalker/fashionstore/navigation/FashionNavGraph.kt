/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.cyberwalker.fashionstore.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.cyberwalker.fashionstore.Liked.LikedScreen
import com.cyberwalker.fashionstore.Liked.LikedScreenActions
import com.cyberwalker.fashionstore.detail.DetailScreen
import com.cyberwalker.fashionstore.detail.DetailScreenActions
import com.cyberwalker.fashionstore.dump.animatedComposable
import com.cyberwalker.fashionstore.home.HomeScreen
import com.cyberwalker.fashionstore.home.HomeScreenActions
import com.cyberwalker.fashionstore.items.ItemsScreen
import com.cyberwalker.fashionstore.items.ItemsScreenActions
import com.cyberwalker.fashionstore.login.SignInScreen
import com.cyberwalker.fashionstore.login.SignInScreenActions
import com.cyberwalker.fashionstore.profile.ProfileScreen
import com.cyberwalker.fashionstore.profile.ProfileScreenActions
import com.cyberwalker.fashionstore.search.SearchScreen
import com.cyberwalker.fashionstore.search.SearchScreenActions
import com.cyberwalker.fashionstore.splash.SplashScreen
import com.cyberwalker.fashionstore.splash.SplashScreenActions
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

sealed class Screen(val name: String, val route: String) {
    object Splash : Screen("splash", "splash")
    object SignIn: Screen("signin","signin")
    object Home : Screen("home", "home")
    object Detail : Screen("detail", "detail")
    object Search : Screen("search", "search")
    object Liked : Screen("liked", "liked")
    object Profile : Screen("profile", "profile")
    object Items : Screen("items", "items")

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FashionNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    actions: NavActions = remember(navController) {
        NavActions(navController)
    }
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier
    ) {
        animatedComposable(Screen.Splash.route) {
            SplashScreen(onAction = actions::navigateToHome)
        }

        animatedComposable(Screen.SignIn.route) {
            SignInScreen(onAction = actions::navigateFromSignIn,navController = navController)
        }

        animatedComposable(Screen.Home.route) {
            HomeScreen(onAction = actions::navigateFromHome,navController = navController)
        }

        animatedComposable(Screen.Detail.route) {
            DetailScreen(onAction = actions::navigateFromDetails)
        }

        animatedComposable(Screen.Search.route) {
            SearchScreen(onAction = actions::navigateToSearch,navController = navController)
        }

        animatedComposable(Screen.Liked.route) {
            LikedScreen(onAction = actions::navigateToLiked,navController = navController)
        }

        animatedComposable(Screen.Profile.route) {
            ProfileScreen(onAction = actions::navigateToProfile,navController = navController)
        }

        animatedComposable(Screen.Items.route) {
            ItemsScreen(onAction = actions::navigateFromItems,navController = navController)
        }
    }
}

class NavActions(private val navController: NavController) {

    fun navigateToHome(_A: SplashScreenActions) {
        navController.navigate(Screen.SignIn.name) {
            popUpTo(Screen.Splash.route){
                inclusive = true
            }
        }
    }

    fun navigateFromSignIn(actions: SignInScreenActions) {
        when (actions) {
            SignInScreenActions.LoadHome -> {
                navController.navigate(Screen.Home.name)
            }
        }
    }

    fun navigateFromHome(actions: HomeScreenActions) {
        when (actions) {
            HomeScreenActions.Items -> {
                navController.navigate(Screen.Items.name)
            }

            HomeScreenActions.Details -> {
                navController.navigate(Screen.Detail.name)
            }


        }
    }

    fun navigateFromDetails(actions: DetailScreenActions) {
        when(actions) {
            DetailScreenActions.Back -> navController.popBackStack()
        }
    }

    fun navigateFromItems(actions: ItemsScreenActions) {
        when(actions) {
            ItemsScreenActions.Back -> {

                navController.popBackStack()
            }

            ItemsScreenActions.Details -> {
                navController.navigate(Screen.Detail.name)
            }
        }
    }

    fun navigateToSearch(actions: SearchScreenActions){
        when(actions){
            SearchScreenActions.LoadSearch -> {
                navController.navigate(Screen.Search.name)
            }
        }
    }

    fun navigateToLiked(actions: LikedScreenActions){
        when(actions){
            LikedScreenActions.LoadLiked -> {
                navController.navigate(Screen.Liked.name)
            }
        }
    }

    fun navigateToProfile(actions: ProfileScreenActions){
        when(actions){
            ProfileScreenActions.LoadProfile -> {
                navController.navigate(Screen.Profile.name)
            }
        }
    }
}