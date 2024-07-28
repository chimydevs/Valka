package com.chimy.valkaapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chimy.valkaapp.ui.theme.ValkaAppTheme

/// Data class para representar a los miembros del equipo
data class TeamMember(
    val name: String,
    val position: String,
    val instagram: String,
    val email: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactoScreen() {
    // Lista de miembros del equipo
    val teamMembers = listOf(
        TeamMember("Hormiga", "C.E.O.", "@hormiga_instagram", "hormiga@example.com"),
        TeamMember("Nko", "Co fundador", "@nko_instagram", "nko@example.com"),
        TeamMember("Chimy", "Android Dev", "@chimy_instagram", "chimy@example.com"),
        TeamMember("Visual Artist 1", "Visual Artist", "@visual_artist1_instagram", "visual_artist1@example.com"),
        TeamMember("Visual Artist 2", "Visual Artist", "@visual_artist2_instagram", "visual_artist2@example.com")
    )

    // Usar un Scaffold para estructurar la pantalla
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Contacto", style = MaterialTheme.typography.titleLarge)
                    }
                }
            )
        }
    ) { paddingValues ->
        // Box contenedor principal
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // LazyColumn para permitir el desplazamiento si hay muchas tarjetas
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(teamMembers) { member ->
                    TeamMemberCard(member)
                    Spacer(modifier = Modifier.height(16.dp)) // Espacio entre los bloques
                }
            }
        }
    }
}

// Composable para mostrar la información de un miembro del equipo
@Composable
fun TeamMemberCard(member: TeamMember) {
    // Card para darle estilo al bloque
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = member.name, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = member.position, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Instagram: ${member.instagram}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Email: ${member.email}", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

// Vista previa de la pantalla de contacto
@Preview(showBackground = true)
@Composable
fun ContactoScreenPreview() {
    ValkaAppTheme {
        ContactoScreen()
    }
}


