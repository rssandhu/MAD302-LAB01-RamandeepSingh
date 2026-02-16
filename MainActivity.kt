/**
 * Course:MAD302 - Lab 1
 * Name: Ramandeep Singh
 * Student ID: A00194321
 * Date: 2026/02/15
 *
 * Description:
 * MainActivity for ProfileListApp.
 * This version connects the UI elements, reads name and age,
 * adds Profile objects to a list, and displays them in a TextView.
 */
package com.example.mad302_lab01_ramandeepsingh

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Main screen of the app.
 * Collects a name and age, stores them in a list of Profile, and shows the list.
 */
class MainActivity : AppCompatActivity() {

    /** Stores all created profiles in memory. */
    private val profiles = mutableListOf<Profile>() // Uses mutableListOf. [web:21]

    // UI views
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonAddProfile: Button
    private lateinit var textViewProfiles: TextView

    /**
     * Called when the activity is first created.
     * Sets up the layout and button click behavior. [web:22]
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to views.
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        buttonAddProfile = findViewById(R.id.buttonAddProfile)
        textViewProfiles = findViewById(R.id.textViewProfiles)

        // Set up button click.
        buttonAddProfile.setOnClickListener {
            // Read name and age (no validation required).
            val name = editTextName.text.toString()
            val ageText = editTextAge.text.toString()
            val age = ageText.toInt() // Assumes valid integer input.

            // Create a new Profile and add it to the list.
            val profile = Profile(name = name, age = age)
            profiles.add(profile) // Add to mutable list. [web:16]

            // Update the TextView that displays all profiles.
            updateProfilesText()
        }
    }

    /**
     * Rebuilds the TextView content from the profiles list using a for loop.
     * Format: "Nevin – 22"
     */
    private fun updateProfilesText() {
        val builder = StringBuilder()

        // For loop over all profiles.
        for (profile in profiles) {
            builder.append(profile.name)
            builder.append(" – ")
            builder.append(profile.age)
            builder.append("\n")
        }

        // Remove trailing newline and set text.
        textViewProfiles.text = builder.toString().trimEnd()
    }
}
