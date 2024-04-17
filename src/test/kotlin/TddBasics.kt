import kotlin.test.Test
import kotlin.test.assertEquals

class TddBasics {
    @Test
    fun firstTest() {
        assertEquals(2, sum(1, 1))
    }

    @Test
    fun secondTest() {
        assertEquals(4, sum(1, 3))
    }

}