package com.chimy.valkaapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.chimy.valkaapp.model.Hero
import com.chimy.valkaapp.repository.HeroRepository

class CountersViewModel: ViewModel() {
    //seleccion de heroe
    val selectedHero = mutableStateOf<Hero?>(null)

    //lsta heroes
    val heroes = HeroRepository.heroes

    //contadores fortaleza
    val runeCount = mutableStateOf(0)
    val lifeCount = mutableStateOf(0)
    val sealCount = mutableStateOf(0)

    fun selectHero(hero: Hero) {
        selectedHero.value = hero
    }

    fun incrementRune() {
        runeCount.value++
    }

    fun decrementRune() {
        if (runeCount.value > 0) runeCount.value--
    }

    fun incrementLife() {
        lifeCount.value++
    }

    fun decrementLife() {
        if (lifeCount.value > 0) lifeCount.value--
    }

    fun incrementSeal() {
        sealCount.value++
    }

    fun decrementSeal() {
        if (sealCount.value > 0) sealCount.value--
    }
}