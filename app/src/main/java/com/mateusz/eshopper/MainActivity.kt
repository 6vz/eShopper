package com.mateusz.eshopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get what is input and button
        var input = findViewById<EditText>(R.id.input)
        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener() {
            var input = input.text.toString()
            if (input.isEmpty()) {
                // show toast
                
        }

    }
}