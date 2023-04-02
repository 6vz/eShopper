package com.mateusz.eshopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get what is input and button
        var input = findViewById<EditText>(R.id.input)
        var button = findViewById<Button>(R.id.button)
        var tabPicker = findViewById<TabLayout>(R.id.picker)

        var lista = arrayOf<String>()

        button.setOnClickListener() {
            var input = input.text.toString()
            if (input.isEmpty()) {

                val builder = android.app.AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please enter a valid input")
                builder.setPositiveButton("OK", null)
                val dialog: android.app.AlertDialog = builder.create()
                dialog.show()
            } else {
                // get currently what's selected on Tab
                var selected = tabPicker.selectedTabPosition
                var category = ""
                if (selected == 0) {
                    category = "nabiał"
                } else if (selected == 1) {
                    category = "roślinne"
                } else {
                    category = "inne"
                }
                var product = "[${category}] ${input}"
                lista += product
                for (i in lista) {
                    println(i)
                    // add to recyclerView with id recyclerView
                    
                }

            }
        }

    }
}