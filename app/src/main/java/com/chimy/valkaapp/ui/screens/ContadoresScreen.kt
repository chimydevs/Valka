package com.chimy.valkaapp.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
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
    var expanded by remember { mutableStateOf(false) }
    val selectedHero by viewModel.selectedHero // Observa el estado del héroe seleccionado
    val health by viewModel.health
    val attack by viewModel.attack
    val armor by viewModel.armor
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // DropdownMenu for hero selection
        Box {
            Button(
                onClick = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = selectedHero?.name ?: "Selecciona tu héroe", // Muestra el texto adecuado
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                viewModel.heroes.forEach { hero ->
                    DropdownMenuItem(
                        text = { Text(text = hero.name) },
                        onClick = {
                            viewModel.onHeroSelected(hero)
                            expanded = false
                        },
                        interactionSource = interactionSource
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Row for the counters
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Attack counter
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Ataque")
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { viewModel.decreaseAttack() }) {
                        Icon(
                            imageVector = Icons.Filled.Remove,
                            contentDescription = "Decrease Attack"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "$attack",
                        modifier = Modifier
                            .wrapContentWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { viewModel.increaseAttack() }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase Attack")
                    }
                }
            }

            // Health counter
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Vida")
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { viewModel.decreaseHealth() }) {
                        Icon(
                            imageVector = Icons.Filled.Remove,
                            contentDescription = "Decrease Health"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "$health",
                        modifier = Modifier
                            .wrapContentWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { viewModel.increaseHealth() }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase Health")
                    }
                }
            }

            // Armor counter
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Armadura")
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { viewModel.decreaseArmor() }) {
                        Icon(
                            imageVector = Icons.Filled.Remove,
                            contentDescription = "Decrease Armor"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "$armor",
                        modifier = Modifier
                            .wrapContentWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { viewModel.increaseArmor() }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase Armor")
                    }
                }
            }
        }

    }
}


@Composable
fun CounterRow(label: String, value: Int, onIncrease: () -> Unit, onDecrease: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(text = label)
        Row {
            Button(onClick = onDecrease) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = value.toString())
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onIncrease) {
                Text(text = "+")
            }
        }
    }
}

@Preview
@Composable
fun previewCountersScreen() {
    HeroCounterContainer()
}

