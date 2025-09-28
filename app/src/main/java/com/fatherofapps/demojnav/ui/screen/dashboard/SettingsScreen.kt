package com.fatherofapps.demojnav.ui.screen.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.fatherofapps.demojnav.ui.screen.BaseScreen
import com.fatherofapps.jnav.annotations.JNav

@Composable
@JNav(
    name = "SettingsNavigation",
    baseRoute = "settings_route",
    destination = "settings_destination"
)
fun SettingsScreen() {
    BaseScreen {
        Text(text = "Settings")
    }
}