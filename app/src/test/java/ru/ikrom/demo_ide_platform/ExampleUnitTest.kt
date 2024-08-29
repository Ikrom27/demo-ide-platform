package ru.ikrom.demo_ide_platform

import org.junit.Test

import org.junit.Assert.*
import ru.ikrom.demo_ide_platform.ui.items.DateUI

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun dataUITest() {
        val timestamp = 1633046400000L
        val uidate = "01.10.2021"
        assertEquals(uidate, DateUI(timestamp).date)
    }
}