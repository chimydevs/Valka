package com.chimy.valkaapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chimy.valkaapp.ui.theme.ValkaAppTheme


@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    val buttonShape = MaterialTheme.shapes.medium // Asegúrate de que esto coincida con el shape definido en tu tema
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background )
            .padding(bottom = 32.dp)
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            val buttonBorderModifier = Modifier.border(
                width = 5.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = buttonShape,

                )
            Button(
                onClick = { navController.navigate("contadores") },
                modifier = Modifier
                    .fillMaxWidth()
                    .then(buttonBorderModifier),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary // Fondo usando color del tema
                ),
                shape = buttonShape
            ) {
                Text(
                    text = "Contadores",
                    color = MaterialTheme.colorScheme.onPrimary
                ) // Texto usando color del tema
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("reglamento") },
                modifier = Modifier
                    .fillMaxWidth()
                    .then(buttonBorderModifier),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary // Fondo usando color del tema
                ),
                shape = buttonShape
            ) {
                Text(
                    text = "Reglamento",
                    color = MaterialTheme.colorScheme.onPrimary
                ) // Texto usando color del tema
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("galeria") },
                modifier = Modifier
                    .fillMaxWidth()
                    .then(buttonBorderModifier),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary // Fondo usando color del tema
                ),
                shape = buttonShape
            ) {
                Text(
                    text = "Galería",
                    color = MaterialTheme.colorScheme.onPrimary
                ) // Texto usando color del tema
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("ranking") },
                modifier = Modifier
                    .fillMaxWidth()
                    .then(buttonBorderModifier),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary // Fondo usando color del tema
                ),
                shape = buttonShape
            ) {
                Text(
                    text = "Ranking",
                    color = MaterialTheme.colorScheme.onPrimary
                ) // Texto usando color del tema
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("contacto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .then(buttonBorderModifier),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary // Fondo usando color del tema
                ),
                shape = buttonShape
            ) {
                Text(
                    text = "Contacto",
                    color = MaterialTheme.colorScheme.onPrimary
                ) // Texto usando color del tema
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ValkaAppTheme {
        MainScreen()
    }
}
