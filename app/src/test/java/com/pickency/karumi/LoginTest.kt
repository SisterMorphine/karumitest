package com.pickency.karumi

import org.junit.Assert
import org.junit.Test
import java.util.*

class LoginTest {

    @Test
    fun successfulLogin() {
        Assert.assertEquals(MainPresenter.login("galicia", "llueve"), true)
    }

    @Test
    fun notSuccessfulLogin() {
        Assert.assertEquals(MainPresenter.login("galicia", "sopotamadre"), false)
    }

    @Test
    fun successfulLogout() {
        Assert.assertEquals(MainPresenter.logout(FixedTimeClock(Date(2222))), true)
    }

    @Test
    fun notSuccessfulLogout() {
        Assert.assertEquals(MainPresenter.logout(FixedTimeClock(Date(1111))), false)
    }
}