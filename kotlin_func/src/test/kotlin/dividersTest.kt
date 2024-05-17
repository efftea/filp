import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class dividersTest {

    @Test
    fun dTail() {
        val main = dividers()
        val expected = 3
        assertEquals(expected, main.dTail(8, 7))
    }

    @Test
    fun countDTail() {
        val main = dividers()
        val expected = 3
        assertEquals(expected, main.countDTail(8, 36, 36-1))
    }

    @Test
    fun funcUp() {
        val main = dividers()
        val expected = 4
        assertEquals(expected, main.funcUp(36, 36, dividers()::countDTail, simple_func()::sumc, simple_func()::mulc))
    }
}