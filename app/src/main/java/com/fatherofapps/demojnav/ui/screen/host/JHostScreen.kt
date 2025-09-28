package com.fatherofapps.demojnav.ui.screen.host

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fatherofapps.demojnav.AppState
import com.fatherofapps.demojnav.data.Address
import com.fatherofapps.demojnav.data.AddressNavType
import com.fatherofapps.demojnav.ui.screen.address.AddressBookNavigation
import com.fatherofapps.demojnav.ui.screen.address.AddressBookScreen
import com.fatherofapps.demojnav.ui.screen.address.AddressDetailNavigation
import com.fatherofapps.demojnav.ui.screen.address.AddressDetailScreen
import com.fatherofapps.demojnav.ui.screen.cart.CartScreen
import com.fatherofapps.demojnav.ui.screen.cart.CartScreenNavigation
import com.fatherofapps.demojnav.ui.screen.home.HomeNavigation
import com.fatherofapps.demojnav.ui.screen.home.HomeScreen

@Composable
fun JHostScreen(
    navController: NavHostController,
    appState: AppState
) {

    NavHost(navController = navController, startDestination = HomeNavigation.route) {

        Log.e("frank","NavHost")

        composable(route = HomeNavigation.route) {
            SideEffect {
                Log.e("frank","Home composable")
            }
            HomeScreen(openCartScreen = { productId, productName, productPrice ->

                appState.navigateTo(
                    CartScreenNavigation.createRoute(
                        productName,
                        productId,
                        productPrice,
                        1
                    )
                )

            }, openAddressBook = {
                Log.e("frank","Home composable openAddressBook")
                appState.navigateTo(AddressBookNavigation.route)
            })
        }


        composable(
            route = CartScreenNavigation.route,
            arguments = CartScreenNavigation.arguments()
        ) {
            Log.e("frank","Cart composable")
            val productName = CartScreenNavigation.productName(it)
            val productId = CartScreenNavigation.productId(it)
            val productPrice = CartScreenNavigation.productPrice(it)
            CartScreen(
                productName = productName,
                productId = productId,
                productPrice = productPrice
            )
        }

        composable(route = AddressBookNavigation.route) {
            SideEffect {
                Log.e("frank","Address book composable")
            }
            AddressBookScreen(openAddressDetailScreen = { address ->

                appState.navigateTo(AddressDetailNavigation.createRoute(address = address))

            })
        }

        composable(
            route = AddressDetailNavigation.route,
            arguments = AddressDetailNavigation.arguments()
        ) {
            val address = AddressDetailNavigation.address(it)
            AddressDetailScreen(address = address)
        }

    }
}