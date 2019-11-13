package com.pickency.karumi

class MainPresenter(val logIn: LogIn, val logOut: LogOut, val mainView: MainView) {

    fun onLoginClicked(username: String, password: String) {
        if (logIn.login(username, password)) {
            mainView.loginSuccess()
        } else
            mainView.showLoginError("Login error")
    }

    fun onLogoutClicked(clock: Clock) {
        if (logOut.logout(clock)) {
            mainView.logoutSuccess()
        } else
            mainView.showLogoutError("Logout error")
    }
}

interface MainView {
    fun loginSuccess()
    fun logoutSuccess()
    fun showLoginError(errorText: String)
    fun showLogoutError(errorText: String)
}