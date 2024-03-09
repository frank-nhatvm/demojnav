package com.fatherofapps.demojnav.ui.screen.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.fatherofapps.demojnav.ui.screen.BaseScreen
import com.fatherofapps.jnav.annotations.JNav

@Composable
@JNav(
    name = "AutomationNavigation",
    baseRoute = "automation_route",
    destination = "automation_destination"
)
fun AutomationScreen() {
    BaseScreen {
        Text("Automation")
    }
}