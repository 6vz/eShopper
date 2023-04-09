package com.mateusz.eshopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val MAX_TASKS = 10 // Maximum number of tasks that can be added
    private var taskCount = 0 // Counter to keep track of number of tasks added

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val input = findViewById<EditText>(R.id.input)
        val button = findViewById<Button>(R.id.button)
        val tabPicker = findViewById<TabLayout>(R.id.picker)

        // Get references to checkboxes
        val c1 = findViewById<CheckBox>(R.id.c1)
        val c2 = findViewById<CheckBox>(R.id.c2)
        val c3 = findViewById<CheckBox>(R.id.c3)
        val c4 = findViewById<CheckBox>(R.id.c4)
        val c5 = findViewById<CheckBox>(R.id.c5)
        val c6 = findViewById<CheckBox>(R.id.c6)
        val c7 = findViewById<CheckBox>(R.id.c7)
        val c8 = findViewById<CheckBox>(R.id.c8)
        val c9 = findViewById<CheckBox>(R.id.c9)
        val c10 = findViewById<CheckBox>(R.id.c10)

        // Array to store tasks
        val tasks = mutableListOf<String>()

        // Set click listener on button to add task
        button.setOnClickListener {
            // Get input text
            val task = input.text.toString().trim()

            // Check if input is empty or if maximum number of tasks has been reached
            if (task.isEmpty()) {
                showDialog("Error", "Please enter a valid task")
            } else if (taskCount >= MAX_TASKS) {
                showDialog("Error", "You have reached the maximum limit of tasks")
            } else {
                // Add task to tasks array and update task count
                tasks.add(task)
                taskCount++

                // Update checkboxes with tasks
                when (taskCount) {
                    1 -> c1.text = task
                    2 -> c2.text = task
                    3 -> c3.text = task
                    4 -> c4.text = task
                    5 -> c5.text = task
                    6 -> c6.text = task
                    7 -> c7.text = task
                    8 -> c8.text = task
                    9 -> c9.text = task
                    10 -> c10.text = task
                }

                // Clear input text
                input.setText("")
            }
        }
    }

    // Helper function to show dialog
    private fun showDialog(title: String, message: String) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }
}
