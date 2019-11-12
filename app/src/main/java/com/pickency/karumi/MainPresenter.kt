package com.pickency.karumi

object MainPresenter {

    fun login(user: String, pass: String): Boolean {
        return ((user == "galicia" && pass == "llueve"))
    }

    fun logout(clock: Clock): Boolean {
        return clock.now().time / 1000 % 2 == 0L
    }

}