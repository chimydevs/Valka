package com.chimy.valkaapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReglamentoScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Reglamento", style = MaterialTheme.typography.titleLarge)
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ResponsiveButton(
                    text = "Básico",
                    onClick = { /* Acción para el botón Básico */ })
                Spacer(modifier = Modifier.height(16.dp))
                ResponsiveButton(
                    text = "Completo",
                    onClick = { /* Acción para el botón Completo */ })
                Spacer(modifier = Modifier.height(16.dp))
                ResponsiveButton(
                    text = "Balance",
                    onClick = { /* Acción para el botón Balance */ })
            }
        }
    }
}

@Composable
fun ResponsiveButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .heightIn(min = 48.dp, max = 64.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun ReglamentoScreenPreview() {
    ValkaAppTheme {
        ReglamentoScreen()
    }
}
