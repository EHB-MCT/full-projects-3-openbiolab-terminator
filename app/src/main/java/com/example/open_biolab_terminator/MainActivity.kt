package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        OpenCVLoader.initDebug()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            val intent = Intent(this,Steps::class.java)
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