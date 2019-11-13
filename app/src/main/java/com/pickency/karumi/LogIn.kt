package com.pickency.karumi

open class LogIn {
    fun login(user: String, pass: String): Boolean {
        return ((user == "galicia" && pass == "llueve"))
    }
}