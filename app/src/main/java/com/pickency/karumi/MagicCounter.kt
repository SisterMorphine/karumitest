package com.pickency.karumi

import android.content.Context

class MagicCounter(private val context: Context, private val counterStorage: CounterStorage) {

    fun increment(random: Int): Int {
        val counter: Int = counterStorage.getCounter() ?: 0
        val updatedCounter: Int
        if (random < 100) {
            updatedCounter = counter + 1

        } else {
            updatedCounter = counter + random
        }
        counterStorage.save(updatedCounter)
        return updatedCounter
    }

    fun decrement(): Int {
        val updatedCounter = (counterStorage.getCounter() ?: 0) - 1
        counterStorage.save(updatedCounter)
        return updatedCounter
    }


}