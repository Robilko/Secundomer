package com.example.secundomer

import com.example.secundomer.util.TimestampMillisecondsFormatter
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTestMillisecondsFormatter {
    @Test
    fun millisecondsFormatter_CorrectOutputMillisecondsTime_ReturnsTrue() {
        assertEquals(TimestampMillisecondsFormatter().format(123), "00:00:123")
    }

    @Test
    fun millisecondsFormatter_CorrectOutputSecondsTime_ReturnsTrue() {
        assertEquals(TimestampMillisecondsFormatter().format(12300), "00:12:300")
    }

    @Test
    fun millisecondsFormatter_CorrectOutputMinutesTime_ReturnsTrue() {
        assertEquals(TimestampMillisecondsFormatter().format(75000), "01:15:000")
    }

    @Test
    fun millisecondsFormatter_CorrectOutputHoursTime_ReturnsTrue() {
        assertEquals(TimestampMillisecondsFormatter().format(49750000), "13:49:10")
    }
}