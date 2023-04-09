package com.mateusz.eshopper

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var input: EditText
    private lateinit var button: Button
    private lateinit var tabPicker: TabLayout

    private val nabial = mutableListOf<String>()
    private val roslinne = mutableListOf<String>()
    private val inne = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        input = findViewById(R.id.input)
        button = findViewById(R.id.button)
        tabPicker = findViewById(R.id.picker)

        // Initialize checkboxes
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

        // Set initial checkbox text to "-"
        c1.text = "-"
        c2.text = "-"
        c3.text = "-"
        c4.text = "-"
        c5.text = "-"
        c6.text = "-"
        c7.text = "-"
        c8.text = "-"
        c9.text = "-"
        c10.text = "-"

        // Set onClickListeners for checkboxes
        c1.setOnClickListener { removeTask(0, c1) }
        c2.setOnClickListener { removeTask(1, c2) }
        c3.setOnClickListener { removeTask(2, c3) }
        c4.setOnClickListener { removeTask(3, c4) }
        c5.setOnClickListener { removeTask(4, c5) }
        c6.setOnClickListener { removeTask(5, c6) }
        c7.setOnClickListener { removeTask(6, c7) }
        c8.setOnClickListener { removeTask(7, c8) }
        c9.setOnClickListener { removeTask(8, c9) }
        c10.setOnClickListener { removeTask(9, c10) }

        // Set onClickListener for button
        button.setOnClickListener {
            val task = input.text.toString().trim()
            if (task.isEmpty()) {
                showErrorDialog()
            } else {
                val category = when (tabPicker.selectedTabPosition) {
                    0 -> nabial
                    1 -> roslinne
                    else -> inne
                }
                addTask(task, category)
            }
        }

        // Set onTabSelectedListener for tabPicker
        tabPicker.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val category = when (tab?.position) {
                    0 -> nabial
                    1 -> roslinne
                    else -> inne
                }
                showTasks(category)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun addTask(task: String, category: MutableList<String>) {
        if (category.size < 10) {
            category.add(task)
            showTasks(category)
        } else {
            showErrorDialog("Cannot add more than 10 tasks per category.")
        }
        input.text.clear()
    }

    private fun removeTask(index: Int, checkbox: CheckBox) {
        val category = when (tabPicker.selectedTabPosition) {
            0 -> nabial
            1 -> roslinne
            else -> inne
        }
        if (index < category.size) {
            category.removeAt(index)
            checkbox.isChecked = false
            checkbox.text = "-"
            showTasks(category)
        }
    }

    private fun showErrorDialog(message: String = "Please enter a valid task name.") {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
        dialog.show()
    }

    private fun showTasks(category: MutableList<String>) {
        val checkboxes = listOf<CheckBox>(
            findViewById(R.id.c1),
            findViewById(R.id.c2),
            findViewById(R.id.c3),
            findViewById(R.id.c4),
            findViewById(R.id.c5),
            findViewById(R.id.c6),
            findViewById(R.id.c7),
            findViewById(R.id.c8),
            findViewById(R.id.c9),
            findViewById(R.id.c10)
        )

        checkboxes.forEachIndexed { index, checkbox ->
            if (index < category.size) {
                checkbox.text = category[index]
                checkbox.isChecked = false
                checkbox.setOnClickListener {
                    removeTask(index, checkbox)
                }
            } else {
                checkbox.text = "-"
                checkbox.isChecked = false
                checkbox.setOnClickListener(null)
            }
        }
    }
}
