package com.example.profilelistapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Course: MAD302 - Lab 1
 * Name: Ramandeep Singh
 * Student ID: A00194321
 * Date: 2026/02/15
 *
 * Description:
 * MainActivity for ProfileListApp.
 * This version connects the UI elements, reads name and age,
 * adds Profile objects to a list, and displays them in a TextView.
 */
class MainActivity : AppCompatActivity() {

    // Mutable list used to store profile objects.
    private val profiles = mutableListOf<Profile>()

    // UI components
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonAddProfile: Button
    private lateinit var textViewProfiles: TextView

    // Tag used for lifecycle logging
    private val tag = "MainActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate called")

        setContentView(R.layout.activity_main)

        // Link XML views with Kotlin variables
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        buttonAddProfile = findViewById(R.id.buttonAddProfile)
        textViewProfiles = findViewById(R.id.textViewProfiles)

        // Set click listener for Add Profile button
        buttonAddProfile.setOnClickListener {
            addProfile()
        }
    }

    /**
     * Reads user input, creates a Profile object,
     * adds it to the list, and updates the TextView.
     *
     * Note:
     * No validation is added because the assignment
     * specifically says validation is not required.
     */
    private fun addProfile() {
        // Read name from EditText and convert to String
        val name = editTextName.text.toString()

        // Read age from EditText and convert to Int
        val age = editTextAge.text.toString().toInt()

        // Create a Profile object using entered values
        val profile = Profile(name, age)

        // Add the new profile to the mutable list
        profiles.add(profile)

        // Update the TextView to display all profiles
        displayProfiles()

        // Optional: clear input fields after adding profile
        editTextName.text.clear()
        editTextAge.text.clear()
    }

    /**
     * Displays all profiles in the TextView using a for loop.
     *
     * Example output:
     * Nevin - 22
     * Alex - 19
     */
    private fun displayProfiles() {
        var result = ""

        // Use a for loop as required in the assignment
        for (profile in profiles) {
            result += "${profile.name} - ${profile.age}\n"
        }

        textViewProfiles.text = result
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy called")
    }
}
