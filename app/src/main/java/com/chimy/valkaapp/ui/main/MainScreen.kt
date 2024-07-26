package com.chimy.valkaapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chimy.valkaapp.R
import com.chimy.valkaapp.ui.theme.ValkaAppTheme

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    val buttonShape = MaterialTheme.shapes.medium

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Parte superior con la imagen
        Image(
            painter = painterResource(id = R.drawable.fondologovalka),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 16.dp)
        )

        // Parte inferior para los botones
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre botones
        ) {
            val buttonBorderModifier = Modifier.border(
                width = 5.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = buttonShape
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

