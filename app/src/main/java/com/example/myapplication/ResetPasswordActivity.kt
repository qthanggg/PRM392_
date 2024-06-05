
package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var backButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        emailEditText = findViewById(R.id.emailEditText)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)
        backButton = findViewById(R.id.backButton) // Initialize the back button

        mAuth = FirebaseAuth.getInstance()

        resetPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        backButton.setOnClickListener {
            finish() // This should only close the current activity and return to the previous one
        }
    }
}
