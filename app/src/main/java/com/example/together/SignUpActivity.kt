package com.example.together


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    // Declare views
    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var conPassEt: EditText
    private lateinit var submitBtn: Button
    private lateinit var signInTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        nameEt = findViewById(R.id.nameEt)
        emailEt = findViewById(R.id.emailEt)
        passwordEt = findViewById(R.id.passwordEt)
        conPassEt = findViewById(R.id.conpassEt)
        submitBtn = findViewById(R.id.submitBtn)
        signInTxt = findViewById(R.id.signInTxt)

        // Submit button click listener
        submitBtn.setOnClickListener {
            val name = nameEt.text.toString().trim()
            val email = emailEt.text.toString().trim()
            val password = passwordEt.text.toString()
            val confirmPassword = conPassEt.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Handle sign-up logic (e.g., Firebase, API call, local DB)
                Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate to Sign In screen
        signInTxt.setOnClickListener {
            // TODO: Replace with actual SignInActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
