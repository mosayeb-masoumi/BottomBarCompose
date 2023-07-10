package com.example.composeoptionalargument

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation (navController: NavController){

    val navItems = listOf(Destination.Home ,Destination.Chat , Destination.Setting)
    
    BottomNavigation(backgroundColor = Color.Red) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id =item.icon), contentDescription = "")},
                label = { Text(text =  item.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        // Pop up to the home destination if already on the home screen
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination on the back stack
                        launchSingleTop = true
                        // Restore state when navigating back to the home destination
                        restoreState = true
                    }
                })
        }
    }
}