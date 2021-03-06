package com.example.open_biolab_terminator

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Result : AppCompatActivity() {

    private lateinit var bgrValue:String
    private lateinit var imgPath:String


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()
        setContentView(R.layout.activity_result)
        var extras = intent.extras
        bgrValue = extras!!.getString("bgrValue").toString()
        imgPath = extras!!.getString("imgPath").toString()


        val resBGR = findViewById<TextView>(R.id.resultDatabaseBGR)
        resBGR.setText("BGR Value: $bgrValue" )


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

        /* About Button */
        val btnMoreInfo = findViewById<Button>(R.id.info)
        btnMoreInfo.setOnClickListener {
            val intent = Intent(this,About::class.java)
            startActivity(intent)
        }

        val btnsubmit = findViewById<Button>(R.id.btnSubmit)
        btnsubmit.setOnClickListener {
            val db = Database(this, null)

            // Add result to database
            db.addResult(bgrValue.toString(), imgPath)
            Toast.makeText(this, bgrValue.toString() + " added to local database", Toast.LENGTH_SHORT).show()
            val results = db.getResult()
            results?.close()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }



    }
}