package com.example.diceroller

class Dice(val sides: Int) {

    fun roll() = (1..sides).random()
}