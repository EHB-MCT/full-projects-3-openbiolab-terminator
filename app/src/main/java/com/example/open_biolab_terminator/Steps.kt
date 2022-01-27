package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class Steps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_instructions)

        val btnHomePage = findViewById<Button>(R.id.home)
        btnHomePage.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val btnCamera = findViewById<Button>(R.id.startanalysing)
        btnCamera.setOnClickListener {
            val intent = Intent(this,Camera::class.java)
            startActivity(intent)
        }

     

    }
}