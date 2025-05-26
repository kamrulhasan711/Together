package com.example.together


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Simulate splash screen delay (e.g., 2 seconds)
        Handler(Looper.getMainLooper()).postDelayed({
            checkUserStatus()
        }, 2000)
    }

    private fun checkUserStatus() {
        val isSignedUp = sharedPreferences.getBoolean("isSignedUp", false)

        if (isSignedUp) {
            // Go to MessageListActivity
            startActivity(Intent(this, ChatListActivity::class.java))
        } else {
            // Go to SignUpActivity
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        finish()  // Prevent returning to splash screen
    }
}
