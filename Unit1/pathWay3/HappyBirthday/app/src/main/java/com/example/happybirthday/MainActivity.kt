package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO : Get from ViewModel
        val targetName = "Sam"
        val senderName = "Emma"

        // TODO : Keep them as properties and instantiate it in a initView() function
        val happyBirthDayTextView: TextView = findViewById(R.id.main_happy_birthday_message)
        val fromTextView: TextView = findViewById(R.id.main_from_message)

        // TODO : Observe LiveData & update UI up to it
        happyBirthDayTextView.text = getString(R.string.happy_birthday_name, targetName)
        fromTextView.text = getString(R.string.from_name, senderName)

    }
}