package dsls

import kotlin.test.Test
import kotlin.test.assertEquals

class LetAlsoApplyExamples {

    @Test
    fun alsoExample() {
        val namedThing = NamedThing().also { it.name = "bob" }

        assertEquals("bob", namedThing.name)
    }

    @Test
    fun applyExample() {
        val namedThing = NamedThing().apply { name = "jim" }

        assertEquals("jim", namedThing.name)
    }

    @Test
    fun letExample() {
        val namedThing = NamedThing("Bob", null)
        var nameString = "Name is Bob"
        var ageString = ""

        namedThing.name.let { nameString = "Name is $it" }
        namedThing.age?.let { ageString = "Age is $it" }

        assertEquals("Name is Bob", nameString)
        assertEquals("", ageString)
    }


}