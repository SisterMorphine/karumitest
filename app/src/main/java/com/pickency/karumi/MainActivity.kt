package com.pickency.karumi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton.setOnClickListener {
            if (usernameEditText.text.toString().equals("galicia") && passwordEditText.text.toString().equals("llueve")) {
                loginSuccess()
            } else
                showError("Error en el login")
        }
        logoutButton.setOnClickListener {
            if (System.currentTimeMillis() / 1000 % 2 == 0L) {
                logoutSuccess()
            } else
                showError("Error en el logout")
        }

    }

    private fun loginSuccess() {
        logoutButton.visibility = View.VISIBLE
        group.visibility = View.GONE
    }

    private fun logoutSuccess() {
        logoutButton.visibility = View.GONE
        group.visibility = View.VISIBLE

    }

    private fun showError(errorText: String) {
        Toast.makeText(this, errorText, Toast.LENGTH_LONG).show()

    }

}
