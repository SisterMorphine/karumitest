package com.pickency.karumi

class StringCalculator {
    fun add(num: String, separator:String): Int {
        if (num.isEmpty())
            return 0
        else return num.split(separator).map { it.toInt() }.sum()
    }

}

