package dsls

import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionExamples {

    @Test
    fun basic() {
        val bob = NamedThing("Bob", 5)
        getOlder(bob, 5)
        assertEquals(10, bob.age)
    }

    @Test
    fun asExtension() {
        val bob = NamedThing("Bob", 5)
        bob.getOlder2(5)
        assertEquals(10, bob.age)
    }

    @Test
    fun listExample() {
        val numbers = listOf(1,2,3)
        val result = addOne(numbers)
        assertEquals(listOf(2,3,4), result)
    }

    @Test
    fun listExtension() {
        val numbers = listOf(1,2,3)
        val result = numbers.addOne2()
        assertEquals(listOf(2,3,4), result)
    }


}