package com.terabyte.networkmonitor.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavBar(navController: NavHostController) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route

    //PS. we can hide BottomNavBar in case of some routes
    //like this
//    if (currentRoute?.contains("home_detail") == true) {
//        return
//    }

    NavigationBar {
        bottomNavItems.forEach { item ->

            NavigationBarItem(
                selected = item.route == currentRoute,
                icon = {
                    if (currentRoute == item.route) {
                        Icon(
                            painter = painterResource(item.iconFilled),
                            contentDescription = ""
                        )
                    }
                    else {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = ""
                        )
                    }
                },
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            //before navigation to item.route,
                            //we delete all the screens above startDestinationId
                            // in back stack.
                            popUpTo(navController.graph.startDestinationId) {
                                //all deleted from back stack screens will save its state
                                //
                                //in case we go back to the screen we deleted from
                                //back stack before, the state of such screen will be
                                //restored.
                                saveState = true
                            }
                            //so, we deleted all the screens above the startDestinationId
                            //but if startDestinationId is our screen, we do not
                            //duplicate the same screen
                            launchSingleTop = true
                            //if we leave current screen and go back later, its state will
                            //be restored
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}