package com.chimy.valkaapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.chimy.valkaapp.model.Hero
import com.chimy.valkaapp.repository.HeroRepository


class CounterViewModel : ViewModel() {
    // Obtener lista de héroes desde el repositorio
    val heroes = HeroRepository.heroes

    // Heroe seleccionado
    val selectedHero = mutableStateOf<Hero?>(null) //  inicializado como null

    // Contadores
    val health = mutableStateOf(0)
    val attack = mutableStateOf(0)
    val armor = mutableStateOf(0)

    fun onHeroSelected(hero: Hero) {
        selectedHero.value = hero
        health.value = hero.initialHealth
        attack.value = hero.initialAttack
        armor.value = hero.initialArmor
    }

    fun increaseHealth() {
        health.value++
    }

    fun decreaseHealth() {
        health.value--
    }

    fun increaseAttack() {
        attack.value++
    }

    fun decreaseAttack() {
        attack.value--
    }

    fun increaseArmor() {
        armor.value++
    }

    fun decreaseArmor() {
        armor.value--
    }
}
