package serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.testng.Assert.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTests {

    @Test
    fun basic() {
        val project = Project("work", "kotlin")
        val json = Json.encodeToString(project)
        val actual = Json.decodeFromString<Project>(json)
        assertEquals(project, actual)
    }

    @Test
    fun optionalPropertyDefault() {
        val actual = Json.decodeFromString<Project>("""{"name": "bob"}""")
        assertEquals(Project("bob", "java"), actual)
    }

    @Test
    fun noBlankProjectNames() {
        assertThrows(IllegalArgumentException::class.java) {
            Project("")
        }
    }

    @Test
    fun genericStuff() {
        val expected = Data(Box(1), Box(Project("wrapped", "english")))
        val json = """{
              "a": {
                "contents": "1"
              },
              "b": {
                "contents": {
                  "name": "wrapped",
                  "language": "english"
                }
              }
            }"""
        val actual = Json.decodeFromString<Data>(json)
        assertEquals(expected, actual)
    }

    @Test
    fun dateFormatValidation() {
        Json.decodeFromString<DateHolder>("""{"date": "12-12-1912"}""")
        assertThrows(IllegalArgumentException::class.java) {
            Json.decodeFromString<DateHolder>("""{"date": "12-12-12"}""")
        }
    }

    @Serializable
    data class TestHouse(val pets: List<Pet>)

    @Test
    fun listContainsAtLeastOneOf() {
        //One cat
        writeReadHouse(TestHouse(listOf(Cat("Blue"))))

        //More than one cat, and other animals
        writeReadHouse(TestHouse(listOf(Cat("Blue"), Cat("Black"), Dog("Poodle"))))

        //Less than one cat
        assertThrows(IllegalArgumentException::class.java) {
            writeReadHouse(TestHouse(listOf(Dog("Poodle"))))
        }
    }

    private fun writeReadHouse(testHouse: TestHouse): House {
        return Json.decodeFromString<House>(Json.encodeToString(testHouse))
    }
}