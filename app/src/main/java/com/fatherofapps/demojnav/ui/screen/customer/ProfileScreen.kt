package com.fatherofapps.demojnav.ui.screen.customer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.fatherofapps.demojnav.ui.screen.BaseScreen
import com.fatherofapps.jnav.annotations.JNav

@Composable
@JNav(
    name = "ProfileNavigation",
    baseRoute = "profile_route",
    destination = "profile_destination"
)
fun ProfileScreen() {
    BaseScreen {
        Text(text = "Profile")
    }
}