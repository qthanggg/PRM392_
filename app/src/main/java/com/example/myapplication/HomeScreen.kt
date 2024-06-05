package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            // Navigate back to login screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Prevent returning to home screen with back button
        }
    }
}