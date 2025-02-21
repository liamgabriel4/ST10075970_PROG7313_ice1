package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get references to UI elements
        val etValOne = findViewById<EditText>(R.id.etValOne)
        val etValTwo = findViewById<EditText>(R.id.etValTwo)
        val btnAdd = findViewById<Button>(R.id.button)
        val resultTextView = findViewById<TextView>(R.id.textView)

        // Set click listener for the button
        btnAdd.setOnClickListener {
            val valOne = etValOne.text.toString().toDoubleOrNull()
            val valTwo = etValTwo.text.toString().toDoubleOrNull()

            if (valOne != null && valTwo != null) {
                val sum = valOne + valTwo
                resultTextView.text = "Result: $sum"
            } else {
                resultTextView.text = "Please enter valid numbers"
            }
        }
    }
}