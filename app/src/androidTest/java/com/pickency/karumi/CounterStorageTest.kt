package com.pickency.karumi

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CounterStorageTest {

    val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    lateinit var counterStorage: CounterStorage
    lateinit var magicCounter: MagicCounter


    @Before
    fun setUp() {
        counterStorage = CounterStorage(appContext)
        counterStorage.clearSharedPreferences()
        magicCounter = MagicCounter(appContext, counterStorage)
    }

    @Test
    fun verifyThatWhenWeSaveAValueAndRetrieveItValueIsCorrect() {
        counterStorage.save(1)
        var savedValue = counterStorage.getCounter()
        assertEquals(1, savedValue)
    }

    @Test
    fun verifyThatWhenWeSaveNoValueOIsSaved() {
        var savedValue = counterStorage.getCounter()
        assertNull(savedValue)
    }


    @Test
    fun verifyThatWheWeSaveAValueAndThenAnotherLastIsRetrieved() {
        counterStorage.save(1)
        counterStorage.save(2)
        var savedValue = counterStorage.getCounter()
        assertEquals(2, savedValue)
    }

    @After
    fun tearDown() {
        counterStorage.clearSharedPreferences()
    }
}
