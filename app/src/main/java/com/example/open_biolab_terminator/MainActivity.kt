package com.example.open_biolab_terminator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_main.*


const val RC_SIGN_IN = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)


       // create all variables
        val later = findViewById<TextView>(R.id.later)
        val btnMoreInfo = findViewById<Button>(R.id.info)
        val btnGetStarted = findViewById<Button>(R.id.camerahome)
        val btnAccount = findViewById<Button>(R.id.profile)
        val btnSavedResults = findViewById<Button>(R.id.boomark)
        val btnHomePage = findViewById<Button>(R.id.home)
        val userName = findViewById<TextView>(R.id.welcome_user)
        val logout = findViewById<TextView>(R.id.logout)



        // set all visibilities
        later.visibility = View.VISIBLE
        userName.visibility = View.GONE
        sign_in_button.visibility = View.VISIBLE
        btnAccount.visibility = View.GONE
        btnGetStarted.visibility = View.GONE
        btnSavedResults.visibility = View.GONE
        btnHomePage.visibility = View.GONE
        btnMoreInfo.visibility = View.GONE
        logout.visibility = View.GONE



        // Hide sign in when clicking on later
        later.setOnClickListener {
            later.visibility = View.GONE
            userName.visibility = View.GONE
            sign_in_button.visibility = View.GONE
            btnAccount.visibility = View.VISIBLE
            btnGetStarted.visibility = View.VISIBLE
            btnSavedResults.visibility = View.VISIBLE
            btnHomePage.visibility = View.VISIBLE
            btnMoreInfo.visibility = View.VISIBLE
            logout.visibility = View.GONE


        }


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        sign_in_button.setSize(SignInButton.SIZE_STANDARD)

        sign_in_button.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)


        }
        //Check if the user is already signed in
        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            later.visibility = View.GONE
            sign_in_button.visibility = View.GONE
            btnAccount.visibility = View.VISIBLE
            btnGetStarted.visibility = View.VISIBLE
            btnSavedResults.visibility = View.VISIBLE
            btnHomePage.visibility = View.VISIBLE
            userName.text = "Welcome " + acct.displayName
            userName.visibility = View.VISIBLE
            btnMoreInfo.visibility = View.VISIBLE
            logout.visibility = View.VISIBLE

        }

        // Let the user log out
        logout.setOnClickListener {
            mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, OnCompleteListener<Void?> {

                    Toast.makeText(this, "Logout succesfull", Toast.LENGTH_SHORT).show()

                    later.visibility = View.VISIBLE
                    userName.visibility = View.GONE
                    sign_in_button.visibility = View.VISIBLE
                    btnAccount.visibility = View.GONE
                    btnGetStarted.visibility = View.GONE
                    btnSavedResults.visibility = View.GONE
                    btnHomePage.visibility = View.GONE
                    btnMoreInfo.visibility = View.GONE
                    logout.visibility = View.GONE

                })
        }



        /* Goes to steps */
        btnGetStarted.setOnClickListener {
            val intent = Intent(this,Steps::class.java)
            startActivity(intent)
        }

        /* Goes to Profile */
        btnAccount.setOnClickListener {
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }

        /* Goes to Saved Results */
        btnSavedResults.setOnClickListener {
            val intent = Intent(this,Data::class.java)
            startActivity(intent)
        }

        /* Goes to About */
        btnMoreInfo.setOnClickListener {
            val intent = Intent(this,About::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {

        val later = findViewById<TextView>(R.id.later)
        val btnMoreInfo = findViewById<Button>(R.id.info)
        val btnGetStarted = findViewById<Button>(R.id.camerahome)
        val btnAccount = findViewById<Button>(R.id.profile)
        val btnSavedResults = findViewById<Button>(R.id.boomark)
        val btnHomePage = findViewById<Button>(R.id.home)
        val userName = findViewById<TextView>(R.id.welcome_user)
        val logout = findViewById<TextView>(R.id.logout)



        try {
           val account = completedTask.getResult(ApiException::class.java)

            later.visibility = View.GONE
            sign_in_button.visibility = View.GONE
            btnAccount.visibility = View.VISIBLE
            btnGetStarted.visibility = View.VISIBLE
            btnSavedResults.visibility = View.VISIBLE
            btnHomePage.visibility = View.VISIBLE
            userName.text = "Welcome " + account.displayName
            userName.visibility = View.VISIBLE
            btnMoreInfo.visibility = View.VISIBLE
            logout.visibility = View.VISIBLE




        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

            Toast.makeText(this, "Could not sign in", Toast.LENGTH_SHORT).show()

        }
    }

}