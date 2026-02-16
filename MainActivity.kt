/**
  * Course:MAD302 - Lab 1
 * Name: Ramandeep Singh
 * Student ID: A00194321
 * Date: 2026/02/15
  *
 * Description:
 * MainActivity for ProfileListApp.
 * Final version with lifecycle logging, profile list handling,
 * and clear inline comments for important logic.
 */
package com.example.profilelistapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Main (and only) activity of the app.
 * Lets the user enter name and age, stores them in a list, and displays them.
 */
class MainActivity : AppCompatActivity() {

    companion object {
        /** Tag used for lifecycle Log.d messages in Logcat. */
        private const val TAG = "MainActivityLifecycle"
    }

    /** Mutable list that stores all Profile objects created while the app runs. [web:21] */
    private val profiles = mutableListOf<Profile>()

    // UI references
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonAddProfile: Button
    private lateinit var textViewProfiles: TextView

    /**
     * Called when the activity is created.
     * Initializes UI components and sets the click listener for the button. [web:3][web:22]
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)

        // Link layout views to properties.
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        buttonAddProfile = findViewById(R.id.buttonAddProfile)
        textViewProfiles = findViewById(R.id.textViewProfiles)

        // When the button is clicked, read the input, create a Profile, and update the TextView.
        buttonAddProfile.setOnClickListener {
            val name = editTextName.text.toString()
            val ageText = editTextAge.text.toString()

            // Convert age string to Int (assignment says no validation required).
            val age = ageText.toInt()

            // Create a new Profile and add it to our list.
            val profile = Profile(name = name, age = age)
            profiles.add(profile)

            // Refresh the TextView so it shows the new list.
            updateProfilesText()
        }
    }

    /**
     * Builds the profile list text using a for loop.
     * Each line looks like: "Nevin – 22".
     */
    private fun updateProfilesText() {
        val builder = StringBuilder()

        // For each Profile in the list, append a line with name and age.
        for (profile in profiles) {
            builder.append(profile.name)
            builder.append(" – ")
            builder.append(profile.age)
            builder.append("\n")
        }

        // Remove the last newline and set text on the TextView.
        textViewProfiles.text = builder.toString().trimEnd()
    }

    /** Called when the activity is becoming visible to the user. [web:3] */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    /** Called when the activity will start interacting with the user. [web:3] */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    /** Called when part of the activity is being covered or losing focus. [web:3][web:5] */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    /** Called when the activity is no longer visible to the user. [web:3] */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    /** Called before the activity is destroyed and resources are cleaned up. [web:3] */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}