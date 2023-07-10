package com.example.composeoptionalargument

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.composeoptionalargument.ui.theme.ComposeOptionalArgumentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOptionalArgumentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    // Handle the back button press
                    BackHandler {
                        if (!navController.popBackStack()) {
                            // If there are no destinations in the back stack, show the home destination
//                            navController.navigate(Destination.Home.route)
                            finish()  // c.lose the app when we are in home and press dvice back button
                        }


                    }


                    Scaffold(
                        bottomBar = { AppBottomNavigation(navController = navController)}
                    ) {
                        NavigationAppHost(navController = navController)
                    }


                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeOptionalArgumentTheme {

    }
}