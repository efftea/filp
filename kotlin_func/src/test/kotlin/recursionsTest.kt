import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class recursionsTest {

    @Test
    fun max() {
        val main = recursions()
        val expected = 9
        assertEquals(expected, main.max(4734693))
    }

    @Test
    fun minOdd() {
        val main = recursions()
        val expected = 3
        assertEquals(expected, main.minOdd(245367))
    }

    @Test
    fun gcd() {
        val main = recursions()
        val expected = 4
        assertEquals(expected, main.gcd(12, 8))
    }

    @Test
    fun maxTail() {
        val main = recursions()
        val expected = 8
        assertEquals(expected, main.maxTail(12345876, 0))
    }

    @Test
    fun minOddTail() {
        val main = recursions()
        val expected = 1
        assertEquals(expected, main.minOddTail(12345, 10))
    }

    @Test
    fun gcdTail() {
        val main = recursions()
        val expected = 4
        assertEquals(expected, main.gcdTail(16, 8, 7))
    }
}