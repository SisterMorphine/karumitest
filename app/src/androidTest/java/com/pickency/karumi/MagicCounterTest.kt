package com.pickency.karumi

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MagicCounterTest {

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
    fun checkIncrementFeatureWorksWithLessThan100InRandom() {
        val result = magicCounter.increment(12)
        var savedValue = counterStorage.getCounter()
        assertEquals(1, result)
        assertEquals(1, savedValue)
    }

    @Test
    fun checkIncrementFeatureWorksWithMoreThan100InRandom() {
        val result = magicCounter.increment(120)
        var savedValue = counterStorage.getCounter()
        assertEquals(120, savedValue)
        assertEquals(120, result)
    }

    @Test
    fun checkIncrementFeatureWorksWithMoreThan100InRandomAndSavedValue() {
        counterStorage.save(1)
        val result = magicCounter.increment(120)
        var savedValue = counterStorage.getCounter()
        assertEquals(121, savedValue)
        assertEquals(121, result)
    }

    @Test
    fun checkDecrementFeatureWorks() {
        counterStorage.save(200)
        val result = magicCounter.decrement()
        assertEquals(199, result)
    }

    @After
    fun tearDown() {
        counterStorage.clearSharedPreferences()
    }
}
