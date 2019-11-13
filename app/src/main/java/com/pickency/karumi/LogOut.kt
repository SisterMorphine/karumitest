package com.pickency.karumi

class LogOut {
    fun logout(clock: Clock): Boolean {
        return clock.now().time / 1000 % 2 == 0L
    }
}