import kotlin.test.Test
import kotlin.test.assertEquals

class AlgoTest {

    @Test
    fun reverseString(){
        val expected = "backwards"
        val actual = "sdrawkcab".reversed()
        assertEquals(expected, actual)
    }

    @Test
    fun reverseStringAlgo(){
        val expected = "backwards"
        val actual = reverse("sdrawkcab")
        assertEquals(expected, actual)
    }

}