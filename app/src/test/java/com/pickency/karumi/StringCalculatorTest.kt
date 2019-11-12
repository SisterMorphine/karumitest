package com.pickency.karumi

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class StringCalculatorTest {
    private lateinit var stringCalculator: StringCalculator


    @Before
    fun setUp() {
        stringCalculator = StringCalculator()
    }

    @Test
    fun returnsZeroIfTestStringIsEmpty() {
        evaluateCalculator("", "/n", 0)

    }

    @Test
    fun returnNumberPassedAsParameterIfThereIsOnlyOne() {
        evaluateCalculator("1/n2", "/n", 3)

    }

    @Test
    fun returnsTheSumOfStringSeparatedByComma() {
        evaluateCalculator("11,11", ",", 22)
    }

    @Test
    fun returnsTheSumOfMoreThan2Strings() {
        evaluateCalculator("1,1,1", ",", 3)
    }


    @Test
    fun returnsTheSumOfStringSeparatedByWithSmallNumbers() {
        evaluateCalculator("1/n2", "/n", 3)
    }

    @Test
    fun returnsTheSumOfStringSeparatedByCommaWithSmallNumbers() {
        evaluateCalculator("2,3", ",", 5)
    }

    @Test(expected = LetiExceptions::class)
    fun customExceptionWhenMinusSign() {
        evaluateCalculator("-1,2", ",", 3)
    }


    private fun evaluateCalculator(input: String, separator: String, expectedResult: Int) {
        val result = stringCalculator.add(input, separator)
        assertEquals(expectedResult, result)

    }
}