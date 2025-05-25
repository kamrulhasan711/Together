package com.example.together


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.togethe.SignUpActivity

class SignInActivity : AppCompatActivity() {

    // Declare UI components
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var goBtn: Button
    private lateinit var signUpTxt: TextView
    private lateinit var forgotPasswordTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)  // Make sure your XML file is named correctly

        // Initialize views
        emailEt = findViewById(R.id.signemailEt)
        passwordEt = findViewById(R.id.signpassEt)
        goBtn = findViewById(R.id.gobtn)
        signUpTxt = findViewById(R.id.signUpTxt)
        forgotPasswordTxt = findViewById(R.id.forgotPasswordTxt)

        // Handle "Go" button click
        goBtn.setOnClickListener {
            val email = emailEt.text.toString().trim()
            val password = passwordEt.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Handle login logic here (Firebase/Auth API/etc.)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Example: Navigate to HomeActivity after login
                // val intent = Intent(this, HomeActivity::class.java)
                // startActivity(intent)
                // finish()
            }
        }

        // Handle Sign Up
        signUpTxt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Handle Forgot Password
        forgotPasswordTxt.setOnClickListener {
            // TODO: Replace with ForgotPasswordActivity if available
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}