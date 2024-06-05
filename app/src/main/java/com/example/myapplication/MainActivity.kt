package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        // Set click listener for the Sign Up TextView
        binding.signupTv.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the Login button
        binding.btnLogin.setOnClickListener {
            if (binding.emailET.text.toString().isEmpty()) {
                binding.emailLayout.error = "Enter Email"
            } else if (binding.passET.text.toString().isEmpty()) {
                binding.passLayout.error = "Enter Password"
            } else {
                auth.signInWithEmailAndPassword(
                    binding.emailET.text.toString(),
                    binding.passET.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this@MainActivity, HomeScreen::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@MainActivity, "Login Failed: " + it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // Set click listener for the Forgot Password TextView
        binding.forgotPasswordTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}
