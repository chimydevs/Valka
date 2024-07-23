package com.chimy.valkaapp.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("contadores") }) {
            Text(text = "Contadores")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("reglamento") }) {
            Text(text = "Reglamento")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("galeria") }) {
            Text(text = "Galería")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("ranking") }) {
            Text(text = "Ranking")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("contacto") }) {
            Text(text = "Contacto")
        }
    }
}
@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}
