package com.example.together


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var messageContainer: LinearLayout
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageView // We'll use the voice button as a send example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Initialize views
        messageContainer = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val scrollView = findViewById<ScrollView>(R.id.messageScrollView) // Add ID to ScrollView in XML
        scrollView.addView(messageContainer)

        messageInput = findViewById(R.id.messageEditText) // Add ID to EditText in XML
        sendButton = findViewById(R.id.voiceButton) // Use ID for voice button in XML

        // Back button
        findViewById<ImageView>(R.id.backButton)?.setOnClickListener {
            finish()
        }

        // Call button
        findViewById<ImageView>(R.id.callButton)?.setOnClickListener {
            Toast.makeText(this, "Calling...", Toast.LENGTH_SHORT).show()
        }

        // Add Contact button
        findViewById<ImageView>(R.id.addContactButton)?.setOnClickListener {
            Toast.makeText(this, "Adding contact...", Toast.LENGTH_SHORT).show()
        }

        // Send message (we're using the voice button here for simplicity)
        sendButton.setOnClickListener {
            val messageText = messageInput.text.toString()
            if (messageText.isNotBlank()) {
                addMessageToChat(messageText)
                messageInput.text.clear()
                scrollView.post {
                    scrollView.fullScroll(View.FOCUS_DOWN)
                }
            }
        }
    }

    private fun addMessageToChat(message: String) {
        val textView = TextView(this).apply {
            text = message
            setPadding(16, 8, 16, 8)
            setBackgroundResource(android.R.drawable.dialog_holo_light_frame)
        }
        messageContainer.addView(textView)
    }
}
