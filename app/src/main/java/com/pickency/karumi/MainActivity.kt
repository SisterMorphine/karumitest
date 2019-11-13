package com.pickency.karumi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(LogIn(), LogOut(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton.setOnClickListener {
            presenter.onLoginClicked(usernameEditText.text.toString(), passwordEditText.text.toString())
        }

        logoutButton.setOnClickListener {
            presenter.onLogoutClicked(SystemClock())

        }

    }

    override fun loginSuccess() {
        logoutButton.visibility = View.VISIBLE
        group.visibility = View.GONE
    }

    override fun logoutSuccess() {
        logoutButton.visibility = View.GONE
        group.visibility = View.VISIBLE

    }

    override fun showLogoutError(errorText: String) {
        Toast.makeText(this, errorText, Toast.LENGTH_LONG).show()
    }

    override fun showLoginError(errorText: String) {
        Toast.makeText(this, errorText, Toast.LENGTH_LONG).show()
    }

}
