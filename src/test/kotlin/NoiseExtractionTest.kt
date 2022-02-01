import java.awt.Color
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NoiseExtractionTest {

    @Test
    fun noOldPeople(){
        val person = YoungPerson("Bob", Color.blue, 10, Past(listOf("Birthday")))

        assertTrue(person.age < 60)

        assertEquals("Bob", person.name)
        assertEquals(Color.blue, person.eyeColor)
        assertEquals(1, person.past.events.size)
        assertEquals("Birthday", person.past.events.first())
    }

    @Test
    fun personCanAge(){
        val person = YoungPerson("Bob", Color.blue, 11, Past(listOf("Birthday")))
        person.age(1)

        assertEquals(12, person.age)

        assertEquals("Bob", person.name)
        assertEquals(Color.blue, person.eyeColor)
        assertEquals(1, person.past.events.size)
        assertEquals("Birthday", person.past.events.first())
    }

}

class NoiseExtractionTest2 {

    @Test
    fun noOldPeople(){
        val person = person(10)

        assertTrue(person.age < 60)
        assertRealPerson(person)
    }

    @Test
    fun personCanAge(){
        val person = person(11)
        person.age(1)

        assertEquals(12, person.age)
        assertRealPerson(person)
    }

    private fun person(age: Int): YoungPerson{
        return YoungPerson("Bob", Color.blue, age, Past(listOf("Birthday")))
    }

    private fun assertRealPerson(person: YoungPerson) {
        assertEquals("Bob", person.name)
        assertEquals(Color.blue, person.eyeColor)
        assertEquals(1, person.past.events.size)
        assertEquals("Birthday", person.past.events.first())
    }

}