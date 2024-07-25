package com.chimy.valkaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chimy.valkaapp.ui.main.MainScreen
import com.chimy.valkaapp.ui.screens.ContactoScreen
import com.chimy.valkaapp.ui.screens.GaleriaScreen
import com.chimy.valkaapp.ui.screens.HeroCounterContainer
import com.chimy.valkaapp.ui.screens.RankingScreen
import com.chimy.valkaapp.ui.screens.ReglamentoScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("contadores") { HeroCounterContainer() }
        composable("reglamento") { ReglamentoScreen() }
        composable("galeria") { GaleriaScreen() }
        composable("ranking") { RankingScreen() }
        composable("contacto") { ContactoScreen() }
    }
}


