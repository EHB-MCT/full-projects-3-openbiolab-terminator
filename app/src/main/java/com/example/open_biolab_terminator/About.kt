package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()
        setContentView(R.layout.activity_about)

        /*
        *
        *
        *   ADD BACK BUTTONS TO ALL ABOUT PAGES
        *
        *
        * */

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
            val intent = Intent(this,Result::class.java)
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

        /* Button to about who */
        val btnWho = findViewById<TextView>(R.id.whoTextButton)
        btnWho.setOnClickListener {
            val intent = Intent(this,About2::class.java)
            startActivity(intent)
        }

        /* Button to about who */
        val btnWhoB = findViewById<TextView>(R.id.whoButton)
        btnWhoB.setOnClickListener {
            val intent = Intent(this,About2::class.java)
            startActivity(intent)
        }

        /* Button to about what */
        val btnWhat = findViewById<TextView>(R.id.whatTextButton)
        btnWhat.setOnClickListener {
            val intent = Intent(this,About3::class.java)
            startActivity(intent)
        }

        /* Button to about what */
        val btnWhatB = findViewById<TextView>(R.id.whatButton)
        btnWhatB.setOnClickListener {
            val intent = Intent(this,About3::class.java)
            startActivity(intent)
        }

        /* Button to about how */
        val btnHow = findViewById<TextView>(R.id.howTextButton)
        btnHow.setOnClickListener {
            val intent = Intent(this,About4::class.java)
            startActivity(intent)
        }

        /* Button to about how */
        val btnHowB = findViewById<TextView>(R.id.howTextButton)
        btnHowB.setOnClickListener {
            val intent = Intent(this,About4::class.java)
            startActivity(intent)
        }

    }
}