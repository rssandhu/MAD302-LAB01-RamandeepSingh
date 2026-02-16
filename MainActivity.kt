/**
  * Course:MAD302 - Lab 1
 * Name: Ramandeep Singh
 * Student ID: A00194321
 * Date: 2026/02/15
 *
 * Description:
 * MainActivity for ProfileListApp.
 * This version includes lifecycle logging for onCreate, onStart, onResume,
 * onPause, onStop, and onDestroy, in addition to the profile list behavior. [web:3]
 */
package com.example.profilelistapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Main screen of the app.
 * Handles user input, maintains a list of profiles, and logs lifecycle events. [web:3]
 */
class MainActivity : AppCompatActivity() {

    companion object {
        /** Tag used for Logcat lifecycle messages. */
        private const val TAG = "MainActivityLifecycle"
    }

    /** In-memory list of profiles created during this session. */
    private val profiles = mutableListOf<Profile>() // mutable list. [web:21]

    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonAddProfile: Button
    private lateinit var textViewProfiles: TextView

    /**
     * Called when the activity is first created.
     * Sets up views and button logic. [web:3]
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        buttonAddProfile = findViewById(R.id.buttonAddProfile)
        textViewProfiles = findViewById(R.id.textViewProfiles)

        buttonAddProfile.setOnClickListener {
            val name = editTextName.text.toString()
            val ageText = editTextAge.text.toString()
            val age = ageText.toInt()

            val profile = Profile(name = name, age = age)
            profiles.add(profile)

            updateProfilesText()
        }
    }

    /**
     * Builds a string listing all profiles and sets it on the TextView.
     */
    private fun updateProfilesText() {
        val builder = StringBuilder()

        for (profile in profiles) {
            builder.append(profile.name)
            builder.append(" – ")
            builder.append(profile.age)
            builder.append("\n")
        }

        textViewProfiles.text = builder.toString().trimEnd()
    }

    /** Called when the activity becomes visible to the user. [web:3] */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    /** Called when the activity starts interacting with the user. [web:3] */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    /** Called when the system is about to start resuming another activity. [web:3][web:5] */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    /** Called when the activity is no longer visible to the user. [web:3] */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    /** Called before the activity is destroyed. [web:3] */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
