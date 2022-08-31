package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class ViewModelTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupackes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcackes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        // Because I'm french, I had to change it to the € format...
        // But the test said "27,00 €" was different from "27,00 €" because of encoding I suppose
        // So I used the numberformat to solve this
        val exceptedPrice = NumberFormat.getCurrencyInstance().format(27)
        assertEquals(exceptedPrice, viewModel.price.value)
    }
}