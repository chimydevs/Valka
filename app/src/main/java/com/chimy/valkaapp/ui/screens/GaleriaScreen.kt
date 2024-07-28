package com.chimy.valkaapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.chimy.valkaapp.R
import com.chimy.valkaapp.ui.theme.ValkaAppTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GaleriaScreen() {
    // Lista mutable para almacenar las imágenes
    val imageList = remember { mutableStateListOf(R.drawable.lapincoya) }
    // Lista mutable para almacenar los títulos de las imágenes
    val imageTitles = remember { mutableStateListOf("La Pincoya") }
    // Estado mutable para almacenar la imagen seleccionada
    var selectedImage by remember { mutableStateOf<Int?>(null) }
    // Estado mutable para almacenar el título de la imagen seleccionada
    var selectedTitle by remember { mutableStateOf<String?>(null) }
    // Scope para lanzar corrutinas
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Centrar el texto del título en el AppBar
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Galería", style = MaterialTheme.typography.titleLarge)
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyVerticalGrid(
                // Definir la grilla con 2 columnas
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(4.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                // Mostrar las imágenes en la grilla
                itemsIndexed(imageList) { index, image ->
                    // Cargar más imágenes cuando se llega al final de la lista
                    if (index >= imageList.size - 1) {
                        scope.launch {
                            loadMoreImages(imageList, imageTitles)
                        }
                    }
                    // Crear un ítem de imagen
                    ImageItem(image, imageTitles[index]) {
                        selectedImage = image
                        selectedTitle = imageTitles[index]
                    }
                }
            }
        }
    }

    // Mostrar el diálogo de detalle de imagen si hay una imagen seleccionada
    selectedImage?.let { image ->
        selectedTitle?.let { title ->
            ImageDetailDialog(image = image, title = title) {
                selectedImage = null
                selectedTitle = null
            }
        }
    }
}

@Composable
fun ImageItem(image: Int, title: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        // Mostrar la imagen
        Image(
            painter = painterResource(id = image),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(4.dp))
        // Mostrar el título de la imagen
        Text(text = title, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun ImageDetailDialog(image: Int, title: String, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Mostrar el título de la imagen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Mostrar la imagen en tamaño completo
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = onDismiss)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }
}

private suspend fun loadMoreImages(imageList: MutableList<Int>, imageTitles: MutableList<String>) {
    // Simular la carga de más imágenes y títulos
    val newImages = List(10) { R.drawable.lapincoya }
    val newTitles = List(10) { "La Pincoya ${imageList.size + it + 1}" }
    imageList.addAll(newImages)
    imageTitles.addAll(newTitles)
}

@Preview(showBackground = true)
@Composable
fun GaleriaScreenPreview() {
    ValkaAppTheme {
        GaleriaScreen()
    }
}