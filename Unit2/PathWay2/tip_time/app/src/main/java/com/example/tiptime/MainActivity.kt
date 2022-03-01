package com.example.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
        binding.costOfServiceEditText.setOnKeyListener { view, keycode, _ ->
            handleKeyEvent(view, keycode)
        }
    }

    /**
     * Calculate the tip based on user inputs and display it's value to the user.
     * If the service cost was empty, display a [Toast] informing them.
     */
    private fun calculateTip() {
        val cost: Double? = binding.costOfServiceEditText.text.toString().toDoubleOrNull()

        if(cost == null) {
            displayEmptyCostGiven()
            return
        }
        val tipPercentage: Double = when(binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        val tip: Double = tipPercentage * cost.let { rawTip ->
            // Round tip if asked
            return@let if(binding.roundUpSwitch.isChecked) ceil(rawTip) else rawTip
        }

        displayTip(tip)
    }

    /**
     * Display the given tip to the user using the $<tip> format.
     *
     * @param tip The value of the tip to display.
     */
    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    /**
     * Display a [Toast] to inform user that service cost field is empty.
     * Also hide the tip result if it has already been displayed.
     */
    private fun displayEmptyCostGiven() {
        binding.tipResult.text = ""
        Toast.makeText(this, R.string.fill_service_cost_field, Toast.LENGTH_LONG).show()
    }

    /**
     * Handle key event when typing the service cost.
     * If enter is pressed (or validate) the keyboard his hidden.
     *
     * @param view The [View] that handle the event.
     * @param keyCode The code associate to the typed key.
     */
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}