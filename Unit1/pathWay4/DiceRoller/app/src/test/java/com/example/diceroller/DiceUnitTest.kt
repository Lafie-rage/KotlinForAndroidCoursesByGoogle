package com.example.diceroller

import junit.framework.Assert.assertTrue
import org.junit.Test

class DiceUnitTest {
    @Test
    fun diceRollTest() {
        val dice = Dice(6)
        assertTrue("Values was intended to be between 1 and ${dice.sides}", dice.roll() in 1..dice.sides)
    }
}