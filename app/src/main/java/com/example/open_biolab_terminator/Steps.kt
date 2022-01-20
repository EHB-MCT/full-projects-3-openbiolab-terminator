package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Steps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_steps)

        val btnHomePage = findViewById<Button>(R.id.btnHomePage)
        btnHomePage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val btnCamera = findViewById<Button>(R.id.btnCamera)
        btnCamera.setOnClickListener {
            val intent = Intent(this,Camera::class.java)
            startActivity(intent)
        }

        val btnAccount = findViewById<Button>(R.id.btnAccount)
        btnAccount.setOnClickListener {

        }

        val btnSavedResults = findViewById<Button>(R.id.btnSavedResults)
        btnSavedResults.setOnClickListener {

        }

        val btnMoreInfo = findViewById<Button>(R.id.btnMoreInfo)
        btnMoreInfo.setOnClickListener {

        }

    }
}