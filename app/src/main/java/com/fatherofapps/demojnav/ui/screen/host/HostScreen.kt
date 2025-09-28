package com.fatherofapps.demojnav.ui.screen.host

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fatherofapps.demojnav.data.Address
import com.fatherofapps.demojnav.data.AddressNavType
import com.fatherofapps.demojnav.ui.screen.address.AddressBookScreen
import com.fatherofapps.demojnav.ui.screen.address.AddressDetailScreen
import com.fatherofapps.demojnav.ui.screen.cart.CartScreen
import com.fatherofapps.demojnav.ui.screen.home.HomeScreen

@Composable
fun HostScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(openCartScreen = { productId, productName, productPrice ->
                navController.navigate("cart/productId=$productId&productName=$productName&productPrice=$productPrice")
            }, openAddressBook = {
                navController.navigate("addressBook")
            })
        }


        composable(
            route = "cart_route/productId={productId}&productName={productName}&productPrice={productPrice}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType // Int::class
                    nullable = false
                },
                navArgument("productName") {
                    type = NavType.StringType // String::class
                    nullable = false
                },
                navArgument("productPrice") {
                    type = NavType.FloatType // Float::class
                    nullable = false
                },
                navArgument("productQty") {
                    type = NavType.IntType // Int::class
                    nullable = false
                },
            )
        ) {
            val productName = it.arguments?.getString("productName") ?: throw Exception("")
            val productId = it.arguments?.getInt("productId") ?: throw Exception("")
            val productPrice = it.arguments?.getFloat("productPrice") ?: throw Exception("")
            CartScreen(
                productName = productName,
                productId = productId,
                productPrice = productPrice
            )
        }

        composable(route = "addressBook") {
            AddressBookScreen(openAddressDetailScreen = { address ->

                navController.navigate("addressDetail&address=${address}")

            })
        }

        composable(route = "addressDetail&address={address}", arguments = listOf(
            navArgument("address") {
                type = AddressNavType()
                nullable = false
            }
        )) {
            val address = it.arguments?.getParcelable<Address>("address") ?: throw Exception("")
            AddressDetailScreen(address = address)
        }

    }
}