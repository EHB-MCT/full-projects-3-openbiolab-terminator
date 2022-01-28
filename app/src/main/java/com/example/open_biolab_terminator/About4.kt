package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class About4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about4)

        /* Home Button */
        /* Gets button id */
        val btnHomePage = findViewById<Button>(R.id.home)
        /* Adds event to id */
        btnHomePage.setOnClickListener {
            /* Takes you to other page once event (click) has happend */
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        /* Bookmark Button */
        val btnBookmark = findViewById<Button>(R.id.boomark)
        btnBookmark.setOnClickListener {
            val intent = Intent(this,Data::class.java)
            startActivity(intent)
        }

        /* Camera Button */
        val btnCamera = findViewById<Button>(R.id.camera)
        btnCamera.setOnClickListener {
            val intent = Intent(this,Camera::class.java)
            startActivity(intent)
        }

        /* Profile Button */
        val btnProfile = findViewById<Button>(R.id.profile)
        btnProfile.setOnClickListener {
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }

        /* back Button */
        val btnBack = findViewById<Button>(R.id.backbutton)
        btnBack.setOnClickListener {
            val intent = Intent(this,About::class.java)
            startActivity(intent)
        }
    }
}