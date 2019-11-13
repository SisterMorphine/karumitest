package com.pickency.karumi

import android.content.Context

class CounterStorage(val context: Context) {

    fun save(counter: Int) {

        val sharedPref = context?.getSharedPreferences("sharedBD", Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putInt("counter", counter)
            commit()
        }
    }

    fun getCounter(): Int? {
        val sharedPref = context?.getSharedPreferences("sharedBD", Context.MODE_PRIVATE)
        if (sharedPref.contains("counter"))
            return sharedPref.getInt("counter", 0)
        return null
    }

    fun clearSharedPreferences() {
        context?.getSharedPreferences("sharedBD", Context.MODE_PRIVATE).apply {
            edit().clear().commit()
        }
    }


}