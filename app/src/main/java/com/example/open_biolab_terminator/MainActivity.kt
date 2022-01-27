package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGetStarted = findViewById<Button>(R.id.camera)
        btnGetStarted.setOnClickListener {
            val intent = Intent(this,Steps::class.java)
            startActivity(intent)
        }

        val btnCamera = findViewById<Button>(R.id.camerahome)
        btnCamera.setOnClickListener {
            val intent = Intent(this,Camera::class.java)
            startActivity(intent)
        }

        val btnAccount = findViewById<Button>(R.id.profile)
        btnAccount.setOnClickListener {

        }

        val btnSavedResults = findViewById<Button>(R.id.boomark)
        btnSavedResults.setOnClickListener {

        }

        val btnMoreInfo = findViewById<Button>(R.id.info)
        btnMoreInfo.setOnClickListener {

        }
    }
}