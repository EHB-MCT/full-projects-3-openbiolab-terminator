package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        val btnGetStarted = findViewById<Button>(R.id.camerahome)
        btnGetStarted.setOnClickListener {
            val intent = Intent(this,Steps::class.java)
            startActivity(intent)
        }

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
            val intent = Intent(this,Data::class.java)
            startActivity(intent)
        }

        val btnMoreInfo = findViewById<Button>(R.id.info)
        btnMoreInfo.setOnClickListener {
            val intent = Intent(this,About::class.java)
            startActivity(intent)
        }
    }
}