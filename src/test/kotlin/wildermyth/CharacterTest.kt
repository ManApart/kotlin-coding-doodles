package wildermyth

import org.testng.annotations.Test
import kotlin.test.assertEquals


class CharacterTest {
    @Test
    fun replaceName(){
        val character = Character("id", "Jim")
        val actual = character.interpolate("<name>")
        assertEquals("Jim", actual)
    }

    @Test
    fun replaceNameInLargerSentence(){
        val character = Character("id", "Jim")
        val actual = character.interpolate("I'm a doctor <name>!")
        assertEquals("I'm a doctor Jim!", actual)
    }
}