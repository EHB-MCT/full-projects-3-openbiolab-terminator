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


class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide()
        setContentView(R.layout.activity_profile)


        /* Log in to show details */
        val name = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.email)
        val loginText = findViewById<TextView>(R.id.login)
        val logout = findViewById<TextView>(R.id.logout)
        val deleteAcc = findViewById<TextView>(R.id.dltAcc)
        val confirm = findViewById<TextView>(R.id.confirmDlt)
        val yes = findViewById<Button>(R.id.yes)
        val no = findViewById<Button>(R.id.no)


        name.visibility = View.GONE
        email.visibility = View.GONE
        logout.visibility = View.GONE
        deleteAcc.visibility = View.GONE
        sign_in_button.visibility = View.VISIBLE
        loginText.visibility = View.VISIBLE
        confirm.visibility = View.GONE
        yes.visibility = View.GONE
        no.visibility = View.GONE



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
            name.text = acct.displayName
            name.visibility = View.VISIBLE
            email.text = acct.email
            email.visibility = View.VISIBLE
            sign_in_button.visibility = View.GONE
            loginText.visibility = View.GONE
            logout.visibility = View.VISIBLE
            deleteAcc.visibility = View.VISIBLE
            confirm.visibility = View.GONE
            yes.visibility = View.GONE
            no.visibility = View.GONE

        }

        // Let the user log out
        logout.setOnClickListener {
            mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, OnCompleteListener<Void?> {

                    Toast.makeText(this, "Logout succesfull", Toast.LENGTH_SHORT).show()

                    name.visibility = View.GONE
                    email.visibility = View.GONE
                    logout.visibility = View.GONE
                    deleteAcc.visibility = View.GONE
                    sign_in_button.visibility = View.VISIBLE
                    loginText.visibility = View.VISIBLE
                    deleteAcc.visibility = View.GONE
                    confirm.visibility = View.GONE
                    yes.visibility = View.GONE
                    no.visibility = View.GONE

                })
        }


        // Delete account
        deleteAcc.setOnClickListener {
            confirm.visibility = View.VISIBLE
            yes.visibility = View.VISIBLE
            no.visibility = View.VISIBLE
            sign_in_button.visibility = View.GONE
            loginText.visibility = View.GONE
            deleteAcc.visibility = View.GONE
            logout.visibility = View.GONE
        }

        yes.setOnClickListener {
            mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this) {

                    Toast.makeText(this, "Account deleted", Toast.LENGTH_SHORT).show()

                    name.visibility = View.GONE
                    email.visibility = View.GONE
                    logout.visibility = View.GONE
                    deleteAcc.visibility = View.GONE
                    sign_in_button.visibility = View.VISIBLE
                    loginText.visibility = View.VISIBLE
                    confirm.visibility = View.GONE
                    yes.visibility = View.GONE
                    no.visibility = View.GONE
                }
        }

        no.setOnClickListener {
            name.visibility = View.VISIBLE
            email.visibility = View.VISIBLE
            sign_in_button.visibility = View.GONE
            loginText.visibility = View.GONE
            logout.visibility = View.VISIBLE
            deleteAcc.visibility = View.VISIBLE
            confirm.visibility = View.GONE
            yes.visibility = View.GONE
            no.visibility = View.GONE
        }


        /* Home Button */
        /* Gets button id */
        val btnHomePage = findViewById<Button>(R.id.home)
        /* Adds event to id */
        btnHomePage.setOnClickListener {
            /* Takes you to other page once event (click) has happend */
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        /* Camera Button */
        val btnCamera = findViewById<Button>(R.id.camera)
        btnCamera.setOnClickListener {
            val intent = Intent(this,Camera::class.java)
            startActivity(intent)
        }

        /* Bookmark Button */
        val btnBookmark = findViewById<Button>(R.id.boomark)
        btnBookmark.setOnClickListener {
            val intent = Intent(this,Data::class.java)
            startActivity(intent)
        }

        /* About Button */
        val btnMoreInfo = findViewById<Button>(R.id.info)
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

        val name = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.email)
        val loginText = findViewById<TextView>(R.id.login)
        val logout = findViewById<TextView>(R.id.logout)
        val deleteAcc = findViewById<TextView>(R.id.dltAcc)
        val confirm = findViewById<TextView>(R.id.confirmDlt)
        val yes = findViewById<Button>(R.id.yes)
        val no = findViewById<Button>(R.id.no)



        try {
            val account = completedTask.getResult(ApiException::class.java)

            name.text = account.displayName
            name.visibility = View.VISIBLE
            email.text = account.email
            email.visibility = View.VISIBLE
            sign_in_button.visibility = View.GONE
            loginText.visibility = View.GONE
            logout.visibility = View.VISIBLE
            deleteAcc.visibility = View.VISIBLE
            confirm.visibility = View.GONE
            yes.visibility = View.GONE
            no.visibility = View.GONE



        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

            Toast.makeText(this, "Invalid data", Toast.LENGTH_SHORT).show()

        }
    }

}