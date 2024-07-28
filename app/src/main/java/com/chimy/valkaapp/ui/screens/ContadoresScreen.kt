package com.chimy.valkaapp.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
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

    //contadores heroe 1
    val health1 by viewModel.health1
    val attack1 by viewModel.attack1
    val armor1 by viewModel.armor1

    //contadores heroe 2
    val health2 by viewModel.health2
    val attack2 by viewModel.attack2
    val armor2 by viewModel.armor2

    //contadores heroe 3
    val health3 by viewModel.health3
    val attack3 by viewModel.attack3
    val armor3 by viewModel.armor3

    //contadores fortaleza
    val healthFor by viewModel.healtFort
    val runas by viewModel.runas
    val sellos by viewModel.sellos

    // Interacción para el dropdownmenu
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Caja heroe 1
        Column {
            Box {
                Button(
                    onClick = { expandedHero1 = !expandedHero1 },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = selectedHero1?.name ?: "Selecciona tu héroe 1",
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                DropdownMenu(
                    expanded = expandedHero1,
                    onDismissRequest = { expandedHero1 = false }
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

            Spacer(modifier = Modifier.height(16.dp))

            // Contadores para el héroe 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Vida",
                        value = health1,
                        onIncrease = { viewModel.increaseHealth1() },
                        onDecrease = { viewModel.decreaseHealth1() }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Ataque",
                        value = attack1,
                        onIncrease = { viewModel.increaseAttack1() },
                        onDecrease = { viewModel.decreaseAttack1() }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Armadura",
                        value = armor1,
                        onIncrease = { viewModel.increaseArmor1() },
                        onDecrease = { viewModel.decreaseArmor1() }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Caja héroe 2
        Column {
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Vida",
                        value = health2,
                        onIncrease = { viewModel.increaseHealth2() },
                        onDecrease = { viewModel.decreaseHealth2() }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Ataque",
                        value = attack2,
                        onIncrease = { viewModel.increaseAttack2() },
                        onDecrease = { viewModel.decreaseAttack2() }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Armadura",
                        value = armor2,
                        onIncrease = { viewModel.increaseArmor2() },
                        onDecrease = { viewModel.decreaseArmor2() }
                    )
                }
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
                                viewModel.onHero2Selected(hero)
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Vida",
                        value = health3,
                        onIncrease = { viewModel.increaseHealth3() },
                        onDecrease = { viewModel.decreaseHealth3() }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Ataque",
                        value = attack3,
                        onIncrease = { viewModel.increaseAttack3() },
                        onDecrease = { viewModel.decreaseAttack3() }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    CounterRow(
                        label = "Armadura",
                        value = armor3,
                        onIncrease = { viewModel.increaseArmor3() },
                        onDecrease = { viewModel.decreaseArmor3() }
                    )
                }
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
                    elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp), // Quitar elevación para parecerse a un texto
                    modifier = Modifier.padding(horizontal = 8.dp) // Ajusta el padding según sea necesario
                ) {
                    Text(
                        text = "Fortaleza",
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Contadores para la fortaleza
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                CounterRow(
                    label = "Runas",
                    value = runas,
                    onIncrease = { viewModel.increaseRunas() },
                    onDecrease = { viewModel.decreaseRunas() }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                CounterRow(
                    label = "Vida",
                    value = healthFor,
                    onIncrease = { viewModel.increaseHealthFor() },
                    onDecrease = { viewModel.decreaseHealthFor() }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                CounterRow(
                    label = "Sellos",
                    value = sellos,
                    onIncrease = { viewModel.increaseSellos() },
                    onDecrease = { viewModel.decreaseSellos() }
                )
            }
        }



    }


}


//caja contadores
@Composable
fun CounterRow(label: String, value: Int, onIncrease: () -> Unit, onDecrease: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(100.dp) // Asegura que todos los contadores tengan el mismo ancho
    ) {
        Text(text = label)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onDecrease, modifier = Modifier.size(20.dp)) {
                Icon(imageVector = Icons.Filled.Remove, contentDescription = "Decrease")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = value.toString(),
                modifier = Modifier
                    .wrapContentWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onIncrease, modifier = Modifier.size(20.dp)) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase")
            }
        }
    }
}


@Preview(showSystemUi = true, device = "id:pixel_3")
@Composable
fun previewCountersScreen() {
    HeroCounterContainer()
}
