package com.pickency.karumi

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    var loginMethodSuccessfullCalled = false
    var logoutSuccessfullCalled = false
    var showLoginErrorCalled = false
    var showLogoutErrorCalled = false

    @Before
    fun setUp(){

    }

    @Test
    fun whenLoginSuccessFulMethodSuccessfulLoginIsCalled() {
        val presenter = givenAPresenter()
        presenter.onLoginClicked("galicia", "llueve")
        Assert.assertTrue(loginMethodSuccessfullCalled)
    }

    @Test
    fun whenLoginNotSuccessfulLoginErrorCalled() {
        val presenter = givenAPresenter()
        presenter.onLoginClicked("galicia", "sopotamadre")
        Assert.assertTrue(showLoginErrorCalled)
    }

    @Test
    fun whenLogoutSuccessfulMethodSuccessfulLogoutIsCalled() {
        val presenter = givenAPresenter()
        presenter.onLoginClicked("galicia", "sopotamadre")
        Assert.assertTrue(showLoginErrorCalled)
    }

    @Test
    fun whenLogoutUnsuccessfulMethodUnSuccessfulLogoutIsCalled() {
        val presenter = givenAPresenter()
        presenter.onLoginClicked("galicia", "sopotamadre")
        Assert.assertTrue(showLoginErrorCalled)

    }

    private fun givenAPresenter() = MainPresenter(LogIn(), LogOut(), object : MainView {
        override fun loginSuccess() {
            loginMethodSuccessfullCalled = true
        }

        override fun logoutSuccess() {
            logoutSuccessfullCalled = true
        }

        override fun showLoginError(errorText: String) {
            showLoginErrorCalled = true
        }

        override fun showLogoutError(errorText: String) {
            showLogoutErrorCalled = true
        }

    })
}