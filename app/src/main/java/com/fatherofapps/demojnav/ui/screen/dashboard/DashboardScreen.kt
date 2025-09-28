package com.fatherofapps.demojnav.ui.screen.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fatherofapps.demojnav.ui.screen.customer.ProfileNavigation
import com.fatherofapps.jnav.annotations.JNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@JNav(
    name = "DashboardNavigation",
    baseRoute = "dashboard_route", destination = "dashboard_destination"
)
fun DashboardScreenRoute(
    mainNavController: NavController,
) {

    val navController = rememberNavController()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Dashboard") }, actions = {
            IconButton(onClick = {
                mainNavController.navigate(ProfileNavigation.route)
            }) {
                Icon(Icons.Default.Person, contentDescription = "")
            }
        })
    },
        bottomBar = {
            NavigationBar {
                IconButton(onClick = {
                    navController.navigate(PlaceScreenNavigation.createRoute())
                }) {
                    Icon(Icons.Default.Home, contentDescription = "")
                }
                IconButton(onClick = {
                    navController.navigate(AutomationNavigation.createRoute())
                }) {
                    Icon(Icons.Default.DateRange, contentDescription = "")
                }
                IconButton(onClick = {
                    navController.navigate(SettingsNavigation.createRoute())
                }) {
                    Icon(Icons.Default.Settings, contentDescription = "")
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = paddingValues.calculateStartPadding(LayoutDirection.Rtl))
        ) {
            NavHost(navController = navController, startDestination = PlaceScreenNavigation.route) {
                composable(route = PlaceScreenNavigation.route) {
                    PlaceScreen()
                }
                composable(route = AutomationNavigation.route) {
                    AutomationScreen()
                }
                composable(route = SettingsNavigation.route) {
                    SettingsScreen()
                }
            }
        }
    }

}


