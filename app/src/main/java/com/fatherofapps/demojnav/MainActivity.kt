package com.fatherofapps.demojnav

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fatherofapps.demojnav.ui.screen.host.JHostScreen
import com.fatherofapps.demojnav.ui.theme.DemoJNavTheme


class AppState(
    val navController: NavHostController,
) {
    fun navigateTo(route:String){
        Log.e("Frank","AppState navigate $route")
        navController.navigate(route)
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
) = remember(navController) {
    AppState(navController)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appState = rememberAppState(navController)
            DemoJNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JHostScreen(
                        navController = navController,
                        appState = appState
                    )
                }
            }
        }
    }
}

