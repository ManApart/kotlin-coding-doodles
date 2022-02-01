import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

data class Person(val name: String, val age: Int) {
    fun disguise(): Person {
        return Person("New Name", age)
    }
}

class MultipleAsserts {

    @Test
    fun addFruit() {
        val person = Person("Bob", 10)
        val disguised = person.disguise()

        assertNotEquals(person, disguised)
        assertEquals(person.age, disguised.age)
        assertEquals("New Name", disguised.name)
    }
}