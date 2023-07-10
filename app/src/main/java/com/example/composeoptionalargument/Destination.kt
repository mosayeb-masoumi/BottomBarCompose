package com.example.composeoptionalargument

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Destination(val route: String , val title:String , val icon:Int ){

    object Home: Destination("home" ,"Home" , R.drawable.ic_home)
    object Chat: Destination("chat","Chat" , R.drawable.ic_chat)
    object Setting: Destination("setting" ,"Setting" , R.drawable.ic_setting)
}

@Composable
fun NavigationAppHost(navController: NavHostController) {

    NavHost(navController, startDestination = Destination.Home.route) {

        composable(Destination.Home.route) {
            HomeScreen(navController)
        }

        composable(Destination.Chat.route){
            ChatScreen()
        }

        composable(Destination.Setting.route) {
            SettingScreen()
        }

    }
}