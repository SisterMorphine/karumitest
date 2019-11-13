package com.pickency.karumi

import org.junit.Assert
import org.junit.Test
import java.util.*

class LoginTest {

    @Test
    fun successfulLogin() {
        Assert.assertEquals(LogIn().login("galicia", "llueve"), true)
    }

    @Test
    fun notSuccessfulLogin() {
        Assert.assertEquals(LogIn().login("galicia", "sopotamadre"), false)
    }

    @Test
    fun successfulLogout() {
        Assert.assertEquals(LogOut().logout(FixedTimeClock(Date(2222))), true)
    }

    @Test
    fun notSuccessfulLogout() {
        Assert.assertEquals(LogOut().logout(FixedTimeClock(Date(1111))), false)
    }
}