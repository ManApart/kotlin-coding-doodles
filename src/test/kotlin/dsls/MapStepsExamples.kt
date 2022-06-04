package dsls

import kotlin.test.Test
import kotlin.test.assertEquals

class MapStepsExamples {

    @Test
    fun addAmount() {
        val numbers = listOf(1, 2, 3)
        val result = numbers.addAmount(2)
        assertEquals(listOf(3, 4, 5), result)
    }

    @Test
    fun passNamedLambda() {
        val numbers = listOf(1, 2, 3)

        val addOne: (Int) -> Int = { it + 1 }

        val result = numbers.updateList(addOne)
        assertEquals(listOf(2, 3, 4), result)
    }

    @Test
    fun passUnnamedLambda() {
        val numbers = listOf(1, 2, 3)

        val result = numbers.updateList({ it - 1 })
        assertEquals(listOf(0,1,2), result)
    }

    @Test
    fun passUnnamedLambda2() {
        val numbers = listOf(1, 2, 3)

        val result = numbers.updateList { it - 1 }
        assertEquals(listOf(0,1,2), result)
    }

    @Test
    fun generic1() {
        val numbers = listOf("one", "two", "three")

        val expected = listOf("num: one", "num: two", "num: three")
        val result = numbers.updateGeneric { "num: $it" }
        assertEquals(expected, result)
    }

    @Test
    fun generic2() {
        val numbers = listOf(1, 2, 3)

        val expected = listOf("num: 1", "num: 2", "num: 3")
        val result = numbers.updateGeneric2 { "num: $it" }
        assertEquals(expected, result)
    }


}