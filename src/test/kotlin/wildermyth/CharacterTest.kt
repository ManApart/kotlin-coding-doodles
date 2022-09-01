package wildermyth

import org.testng.annotations.Test
import kotlin.random.Random
import kotlin.test.assertEquals


class CharacterTest {
    @Test
    fun getTemplate(){
        assertEquals("name", getTemplate(0, "<name>" ))
        assertEquals(null, getTemplate(0, "name" ))
        assertEquals("mf:his <name>/her <name>", getTemplate(0, "<mf:his <name>/her <name>>"))
        assertEquals("mf:his <name>/her <name>", getTemplate(0, "<mf:his <name>/her <name>> is my <name>"))
        assertEquals("name", getTemplate(2, "<mf:his <name>/her <name>> is my <name>"))
    }
//    @Test
//    fun getTemplate(){
//        assertEquals("<name>", getTemplate(0, "<name>" ))
//        assertEquals(null, getTemplate(0, "name" ))
//        assertEquals("<mf:his <name>/her <name>>", getTemplate(0, "<mf:his <name>/her <name>>"))
//        assertEquals("<mf:his <name>/her <name>>", getTemplate(0, "<mf:his <name>/her <name>> is my <name>"))
//        assertEquals("<name>", getTemplate(2, "<mf:his <name>/her <name>> is my <name>"))
//    }

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

    @Test
    fun nestedReplace(){
        val line = "The <bookish/hothead/poet:<mf:man/woman> was a nerd/bruiser/acclaimed <mf:actor/actress>>"

        val characterA = Character("id", "Tom", sex= Sex.MALE, personality = buildPersonality(Personality.BOOKISH))
        assertEquals("The man was a nerd", characterA.interpolate2(line))

        val characterB = Character("id", "Tom", sex= Sex.MALE, personality = buildPersonality(Personality.HOTHEAD))
        assertEquals("The bruiser", characterB.interpolate2(line))

        val characterC = Character("id", "Tom", sex= Sex.MALE, personality = buildPersonality(Personality.POET))
        assertEquals("The acclaimed actor", characterC.interpolate2(line))

        val characterD = Character("id", "Sally", sex= Sex.FEMALE, personality = buildPersonality(Personality.POET))
        assertEquals("The acclaimed actress", characterD.interpolate2(line))
    }

}

private fun buildPersonality(highest: Personality): Map<Personality, Int> {
    val map = Personality.values().associateWith { Random.nextInt(0, 80) }.toMutableMap()
    map[highest] = 85

    return map
}