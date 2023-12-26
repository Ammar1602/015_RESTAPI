package com.example.aplikasidatasiswa.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplikasidatasiswa.ui.Home.screen.DestinasiHome
import com.example.aplikasidatasiswa.ui.Home.screen.HomeScreen
import com.example.aplikasidatasiswa.ui.kontak.screen.DestinasiEntry

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
        ){
            composable(DestinasiHome.route){
                HomeScreen(navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                    onDetailClick = {
                    })
            }
                composable(DestinasiEntry.route){

                }
    }
}