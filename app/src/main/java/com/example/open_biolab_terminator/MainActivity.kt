package com.example.open_biolab_terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (! Python.isStarted()) {
            Python.start( AndroidPlatform(applicationContext))
        }
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        /* Goes to steps */
        val btnGetStarted = findViewById<GifImageView>(R.id.camerahome)
        btnGetStarted.setOnClickListener {
            val intent = Intent(this,Steps::class.java)
            startActivity(intent)
        }

        /* Goes to Profile */
        val btnAccount = findViewById<Button>(R.id.profile)
        btnAccount.setOnClickListener {
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }

        /* Goes to Saved Results */
        val btnSavedResults = findViewById<Button>(R.id.boomark)
        btnSavedResults.setOnClickListener {
            val intent = Intent(this,Data::class.java)
            startActivity(intent)
        }

        /* Goes to About */
        val btnMoreInfo = findViewById<Button>(R.id.info)
        btnMoreInfo.setOnClickListener {
            val intent = Intent(this,About::class.java)
            startActivity(intent)
        }
        
    }
}