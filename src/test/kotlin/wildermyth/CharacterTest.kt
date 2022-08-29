package wildermyth

import org.testng.annotations.Test
import kotlin.test.assertEquals


class CharacterTest {
    @Test
    fun replaceName(){
        val character = Character("id", "Bob")
        val actual = character.interpolate("<name>")
        assertEquals("Bob", actual)
    }

    @Test
    fun replaceNameInLargerSentence(){
        val character = Character("id", "Jim")
        val actual = character.interpolate("I'm a doctor <name>!")
        assertEquals("I'm a doctor Jim!", actual)
    }

    @Test
    fun replaceTwice(){
        val character = Character("id", "Tom")
        val actual = character.interpolate("<name> is my name, said <name>.")
        assertEquals("Tom is my name, said Tom.", actual)
    }

    @Test
    fun maleFemale(){
        val line = "<mf:He/She> grabbed <mf:his/her> weapon."
        val characterA = Character("id", "Tom", sex= Sex.MALE)
        assertEquals("He grabbed his weapon.", characterA.interpolate(line))

        val characterB = Character("id", "Sally", sex= Sex.FEMALE)
        assertEquals("She grabbed her weapon.", characterB.interpolate(line))

        val characterC = Character("id", "Sally", sex= Sex.UNKNOWN)
        val lineC = "<mf:He/She/They> grabbed <mf:his/her/their> weapon."
        assertEquals("They grabbed their weapon.", characterC.interpolate(lineC))
    }
}