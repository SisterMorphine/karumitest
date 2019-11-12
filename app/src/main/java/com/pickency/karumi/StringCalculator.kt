package com.pickency.karumi

class StringCalculator {
    fun add(num: String, separator: String) =
        when {
            num.isEmpty() -> 0
            num.contains("-") -> throw LetiExceptions()
            else -> num.split(separator).map { it.toInt() }.sum()
        }
}

