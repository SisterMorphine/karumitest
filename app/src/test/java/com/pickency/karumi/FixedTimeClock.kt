package com.pickency.karumi

import java.util.*

class FixedTimeClock(private val date:Date): Clock {
    override fun now(): Date {
        return date
    }
}