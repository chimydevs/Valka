package com.chimy.valkaapp.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chimy.valkaapp.ui.theme.ValkaAppTheme
import com.chimy.valkaapp.viewmodel.CounterViewModel

@Composable
fun HeroCounterContainer(viewModel: CounterViewModel = viewModel()) {
    // Estados de expansión de los menús desplegables
    var expandedHero1 by remember { mutableStateOf(false) }
    var expandedHero2 by remember { mutableStateOf(false) }
    var expandedHero3 by remember { mutableStateOf(false) }

    // Selección y estados de los héroes
    val selectedHero1 by viewModel.selectedHero1
    val selectedHero2 by viewModel.selectedHero2
    val selectedHero3 by viewModel.selectedHero3

    // Contadores héroe 1
    val health1 by viewModel.health1
    val attack1 by viewModel.attack1
    val armor1 by viewModel.armor1

    // Contadores héroe 2
    val health2 by viewModel.health2
    val attack2 by viewModel.attack2
    val armor2 by viewModel.armor2

    // Contadores héroe 3
    val health3 by viewModel.health3
    val attack3 by viewModel.attack3
    val armor3 by viewModel.armor3

    // Contadores fortaleza
    val healthFor by viewModel.healtFort
    val runas by viewModel.runas
    val sellos by viewModel.sellos

    // Interacción para el dropdownmenu
    val interactionSource = remember { MutableInteractionSource() }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            // Caja héroe 1
            Column {
                BoxWithConstraints {
                    val buttonWidth = with(LocalDensity.current) { constraints.maxWidth.toDp() }
                    val dropdownWidth = 345.dp // Ajusta el ancho del DropdownMenu si es necesario

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = { expandedHero1 = !expandedHero1 },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = selectedHero1?.name ?: "Selecciona tu héroe 1",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        DropdownMenu(
                            expanded = expandedHero1,
                            onDismissRequest = { expandedHero1 = false },
                            modifier = Modifier
                                .width(dropdownWidth)
                                .offset(x = (buttonWidth - dropdownWidth) / 2)
                        ) {
                            viewModel.heroes.forEach { hero ->
                                DropdownMenuItem(
                                    text = { Text(text = hero.name) },
                                    onClick = {
                                        viewModel.onHero1Selected(hero)
                                        expandedHero1 = false
                                    },
                                    interactionSource = interactionSource
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Contadores para el héroe 1
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CounterRow(
                        label = "Vida",
                        value = health1,
                        onIncrease = { viewModel.increaseHealth1() },
                        onDecrease = { viewModel.decreaseHealth1() })
                    CounterRow(
                        label = "Ataque",
                        value = attack1,
                        onIncrease = { viewModel.increaseAttack1() },
                        onDecrease = { viewModel.decreaseAttack1() })
                    CounterRow(
                        label = "Armadura",
                        value = armor1,
                        onIncrease = { viewModel.increaseArmor1() },
                        onDecrease = { viewModel.decreaseArmor1() })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Caja héroe 2
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp)) // Recorte
                    .background(MaterialTheme.colorScheme.secondary)
                    .border(
                        width = 2.dp, // Ancho del borde
                        color = MaterialTheme.colorScheme.secondary, // Color del borde
                        shape = RoundedCornerShape(20.dp) // Forma redondeada
                    )
                    .padding(16.dp) // Padding para evitar que el contenido toque el borde
            ) {
                Box {
                    Button(
                        onClick = { expandedHero2 = !expandedHero2 },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = selectedHero2?.name ?: "Selecciona tu héroe 2",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    DropdownMenu(
                        expanded = expandedHero2,
                        onDismissRequest = { expandedHero2 = false }
                    ) {
                        viewModel.heroes.forEach { hero ->
                            DropdownMenuItem(
                                text = { Text(text = hero.name) },
                                onClick = {
                                    viewModel.onHero2Selected(hero)
                                    expandedHero2 = false
                                },
                                interactionSource = interactionSource
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Contadores para el héroe 2
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CounterRow(
                        label = "Vida",
                        value = health2,
                        onIncrease = { viewModel.increaseHealth2() },
                        onDecrease = { viewModel.decreaseHealth2() })
                    CounterRow(
                        label = "Ataque",
                        value = attack2,
                        onIncrease = { viewModel.increaseAttack2() },
                        onDecrease = { viewModel.decreaseAttack2() })
                    CounterRow(
                        label = "Armadura",
                        value = armor2,
                        onIncrease = { viewModel.increaseArmor2() },
                        onDecrease = { viewModel.decreaseArmor2() })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Caja héroe 3
            Column {
                Box {
                    Button(
                        onClick = { expandedHero3 = !expandedHero3 },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = selectedHero3?.name ?: "Selecciona tu héroe 3",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    DropdownMenu(
                        expanded = expandedHero3,
                        onDismissRequest = { expandedHero3 = false }
                    ) {
                        viewModel.heroes.forEach { hero ->
                            DropdownMenuItem(
                                text = { Text(text = hero.name) },
                                onClick = {
                                    viewModel.onHero3Selected(hero)
                                    expandedHero3 = false
                                },
                                interactionSource = interactionSource
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Contadores para el héroe 3
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CounterRow(
                        label = "Vida",
                        value = health3,
                        onIncrease = { viewModel.increaseHealth3() },
                        onDecrease = { viewModel.decreaseHealth3() })
                    CounterRow(
                        label = "Ataque",
                        value = attack3,
                        onIncrease = { viewModel.increaseAttack3() },
                        onDecrease = { viewModel.decreaseAttack3() })
                    CounterRow(
                        label = "Armadura",
                        value = armor3,
                        onIncrease = { viewModel.increaseArmor3() },
                        onDecrease = { viewModel.decreaseArmor3() })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Caja Fortaleza
            Column {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /* No hace nada */ },
                        elevation = ButtonDefaults.buttonElevation(
                            0.dp,
                            0.dp,
                            0.dp,
                            0.dp,
                            0.dp
                        )

                    ) {
                        Text(
                            text = "Fortaleza",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Contadores para la fortaleza
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CounterRow(
                        label = "Vida",
                        value = healthFor,
                        onIncrease = { viewModel.increaseHealthFor() },
                        onDecrease = { viewModel.decreaseHealthFor() })
                    CounterRow(
                        label = "Runas",
                        value = runas,
                        onIncrease = { viewModel.increaseRunas() },
                        onDecrease = { viewModel.decreaseRunas() })
                    CounterRow(
                        label = "Sellos",
                        value = sellos,
                        onIncrease = { viewModel.increaseSellos() },
                        onDecrease = { viewModel.decreaseSellos() })
                }
            }
        }
        VerticalScrollbar(
            scrollState = scrollState,
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight()
        )
    }
}

@Composable
fun VerticalScrollbar(
    scrollState: ScrollState,
    modifier: Modifier = Modifier,
    width: Dp = 8.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    val scrollPercentage = scrollState.value.toFloat() / scrollState.maxValue.toFloat()

    Canvas(modifier = modifier) {
        val scrollbarHeight = size.height * scrollPercentage
        drawLine(
            color = color,
            start = Offset(x = size.width / 2, y = 0f),
            end = Offset(x = size.width / 2, y = scrollbarHeight),
            strokeWidth = width.toPx()
        )
    }
}



@Composable
fun CounterRow(
    label: String,
    value: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onDecrease, modifier = Modifier.size(20.dp)) {
                Icon(imageVector = Icons.Filled.Remove, contentDescription = "Decrease")
            }
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            IconButton(onClick = onIncrease, modifier = Modifier.size(20.dp)) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase")
            }
        }
    }

}


@Preview(
    showSystemUi = true, showBackground = true,
    device = "id:pixel_3_xl"
)
@Composable
fun PreviewHeroCounterContainer() {
    ValkaAppTheme {
        HeroCounterContainer()
    }
}

