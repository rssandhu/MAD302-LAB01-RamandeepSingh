/**
 * Course: MAD302 - Lab 1
 * Name: Ramandeep Singh
 * Student ID: A00194321
 * Date: 2026/02/15
 *
 * Description:
 * This file defines the Profile data class used by the app.
 * A Profile contains a person's name and age.
 */
package com.example.mad302_lab01_ramandeepsingh

/**
 * Represents a single user profile with a name and age.
 *
 * @property name The profile name entered by the user.
 * @property age The profile age entered by the user.
 */
data class Profile(
    val name: String,
    val age: Int
)
