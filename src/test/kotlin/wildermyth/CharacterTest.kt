package wildermyth

import org.testng.annotations.Test
import kotlin.random.Random
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
    fun improperTemplateFormat(){
        val character = Character("id", "Tom")
        assertEquals("<name", character.interpolate("<name"))
        assertEquals("name>", character.interpolate("name>"))
        assertEquals("<name", character.interpolate("<<name>"))
    }

    @Test
    fun defaultToLast(){
        val character = Character("id", "Tom")
        val unknownSingle = character.interpolate("<unknown>")
        assertEquals("unknown", unknownSingle)

        val unknownParts = character.interpolate("<unknownstuff:one/two/last>")
        assertEquals("last", unknownParts)
    }

    @Test
    fun maleFemale(){
        val line = "<mf:He/She> grabbed <mf:his/her> weapon."
        val characterA = Character("id", "Tom", sex= Sex.MALE)
        assertEquals("He grabbed his weapon.", characterA.interpolate(line))

        val characterB = Character("id", "Sally", sex= Sex.FEMALE)
        assertEquals("She grabbed her weapon.", characterB.interpolate(line))

        val characterC = Character("id", "Sam", sex= Sex.UNKNOWN)
        val lineC = "<mf:He/She/They> grabbed <mf:his/her/their> weapon."
        assertEquals("They grabbed their weapon.", characterC.interpolate(lineC))
    }

    @Test
    fun highestPersonality(){
        val line = "<goofball/loner/snark:a silly hat/a few minutes alone/a break from babysitting>"

        val characterA = Character("id", "Tom", personality = buildPersonality(Personality.GOOFBALL))
        assertEquals("a silly hat", characterA.interpolate(line))

        val characterB = Character("id", "Sally", personality = buildPersonality(Personality.LONER))
        assertEquals("a few minutes alone", characterB.interpolate(line))

        val characterC = Character("id", "Sally", personality = buildPersonality(Personality.SNARK))
        assertEquals("a break from babysitting", characterC.interpolate(line))
    }
}

private fun buildPersonality(highest: Personality): Map<Personality, Int> {
    val map = Personality.values().associateWith { Random.nextInt(0, 80) }.toMutableMap()
    map[highest] = 85

    return map
}