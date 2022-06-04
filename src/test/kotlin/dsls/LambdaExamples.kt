package dsls

import kotlin.test.Test
import kotlin.test.assertEquals

class LambdaExamples {

    @Test
    fun basic() {
        val namedThing = NamedThing()
        val lambda = { namedThing.name = "Hello Lambda" }
        lambda()
        assertEquals("Hello Lambda", namedThing.name)
    }

    @Test
    fun typed() {
        val namedThing = NamedThing()
        val lambda: () -> Unit = { namedThing.name = "Hello Lambda" }
        lambda()
        assertEquals("Hello Lambda", namedThing.name)
    }

    @Test
    fun input() {
        val namedThing = NamedThing()
        val lambda: (String) -> Unit = { namedThing.name = it }
        lambda("Passed In")
        assertEquals("Passed In", namedThing.name)
    }

    @Test
    fun inputNamedParam() {
        val namedThing = NamedThing()
        val lambda: (String) -> Unit = { newName ->
            namedThing.name = newName
        }
        lambda("Passed In")
        assertEquals("Passed In", namedThing.name)
    }

    @Test
    fun multipleParams() {
        val namedThing = NamedThing()
        val lambda: (NamedThing, String) -> Unit = { thing, newName ->
            thing.name = newName
        }
        lambda(namedThing, "Passed In")
        assertEquals("Passed In", namedThing.name)
    }


}