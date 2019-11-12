package com.pickency.karumi

import java.util.*

interface Clock{
fun now(): Date

}

class SystemClock : Clock {
    override fun now():Date {
        return Date()
    }
}

