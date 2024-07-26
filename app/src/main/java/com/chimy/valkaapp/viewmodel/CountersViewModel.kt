package com.chimy.valkaapp.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.chimy.valkaapp.model.Hero
import com.chimy.valkaapp.repository.HeroRepository

class CounterViewModel : ViewModel() {


    // Obtener lista de héroes desde el repositorio
    val heroes = HeroRepository.heroes

    // Héroes seleccionados
    val selectedHero1 = mutableStateOf<Hero?>(null)
    val selectedHero2 = mutableStateOf<Hero?>(null)
    val selectedHero3 = mutableStateOf<Hero?>(null)

    // Contadores para héroe 1
    val health1 = mutableStateOf(0)
    val attack1 = mutableStateOf(0)
    val armor1 = mutableStateOf(0)

    // Contadores para héroe 2
    val health2 = mutableStateOf(0)
    val attack2 = mutableStateOf(0)
    val armor2 = mutableStateOf(0)

    // Contadores para héroe 3
    val health3 = mutableStateOf(0)
    val attack3 = mutableStateOf(0)
    val armor3 = mutableStateOf(0)

    // Selección de héroe 1
    fun onHero1Selected(hero: Hero) {
        selectedHero1.value = hero
        health1.value = hero.initialHealth
        attack1.value = hero.initialAttack
        armor1.value = hero.initialArmor
    }

    // Selección de héroe 2
    fun onHero2Selected(hero: Hero) {
        selectedHero2.value = hero
        health2.value = hero.initialHealth
        attack2.value = hero.initialAttack
        armor2.value = hero.initialArmor
    }

    // Selección de héroe 3
    fun onHero3Selected(hero: Hero) {
        selectedHero2.value = hero
        health3.value = hero.initialHealth
        attack3.value = hero.initialAttack
        armor3.value = hero.initialArmor
    }

    // Incrementar/disminuir contadores para héroe 1
    fun increaseHealth1() { health1.value++ }
    fun decreaseHealth1() { health1.value-- }
    fun increaseAttack1() { attack1.value++ }
    fun decreaseAttack1() { attack1.value-- }
    fun increaseArmor1() { armor1.value++ }
    fun decreaseArmor1() { armor1.value-- }

    // Incrementar/disminuir contadores para héroe 2
    fun increaseHealth2() { health2.value++ }
    fun decreaseHealth2() { health2.value-- }
    fun increaseAttack2() { attack2.value++ }
    fun decreaseAttack2() { attack2.value-- }
    fun increaseArmor2() { armor2.value++ }
    fun decreaseArmor2() { armor2.value-- }

    // Incrementar/disminuir contadores para héroe 2
    fun increaseHealth3() { health2.value++ }
    fun decreaseHealth3() { health2.value-- }
    fun increaseAttack3() { attack2.value++ }
    fun decreaseAttack3() { attack2.value-- }
    fun increaseArmor3() { armor2.value++ }
    fun decreaseArmor3() { armor2.value-- }

}
