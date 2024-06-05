package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            if(binding.emailET.text.toString().isEmpty()){
                binding.emailLayout.error="Enter Email"
            }
            else if(binding.passET.text.toString().isEmpty()){
                binding.passLayout.error="Enter Password"
            }
            else if(binding.confirmPassET.text.toString().isEmpty()){
                binding.confirmPassLayout.error="Enter Password Again"
            }
            else if(!(binding.passET.text.toString().equals(binding.confirmPassET.text.toString()))){
                binding.confirmPassLayout.error="Password must be same"
            }
            else {
                var intent=Intent(this@SignUpActivity,OtpActivity::class.java)
                intent.putExtra("email",binding.emailET.text.toString())
                intent.putExtra("pass",binding.passET.text.toString())
                startActivity(intent)
            }
        }



    }
}
