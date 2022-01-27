package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnCamera = findViewById<Button>(R.id.camera)
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

        val btnHomePage = findViewById<Button>(R.id.home)
        btnHomePage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}