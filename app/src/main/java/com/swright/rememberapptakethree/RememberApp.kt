package com.swright.rememberapptakethree

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.swright.rememberapptakethree.screens.FrontPageScreen
import com.swright.rememberapptakethree.screens.RememberListScreen
import com.swright.rememberapptakethree.screens.SubMenuScreen
import com.swright.rememberapptakethree.viewmodels.RememberViewModel

@Composable
fun RememberApp(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
//    val rememberViewModel = ViewModelProvider(this)[RememberViewModel::class.java]


    NavHost(
        navController = navController,
        startDestination = "front_page_screen"
    ) {
        composable(route = "front_page_screen") {
            FrontPageScreen(
                onItemClicked = { navController.navigate("sub_menu_screen/" + it) }
            )
        }
        composable(
            route = "sub_menu_screen/{screen_title}",
            arguments = listOf(
                navArgument(name = "screen_title") {
                    type = NavType.StringType
                    defaultValue = "Remember App"
                }
            )) { entry ->
            SubMenuScreen(
                screenTitle = entry.arguments?.getString("screen_title"),
                onSubMenuItemClicked = { navController.navigate("remember_list_screen/" + it) })
        }
        composable(
            route = "remember_list_screen/{list_screen_title}",
            arguments = listOf(
                navArgument(name = "list_screen_title") {
                    type = NavType.StringType
                    defaultValue = "Remember App"
                }
            )) { entry ->
            RememberListScreen(
                screenTitle = entry.arguments?.getString("list_screen_title")
            )
        }
    }

}