package dsls

import kotlin.test.Test
import kotlin.test.assertEquals

class DogBuilderExamples {

    @Test
    fun dogExample(){
        val oleBoy = dog("Ole Boy") {
            age(3)
            breed(Breed.SNICKERDOODLE)
            hair(HairLength.LONG)
        }

        val buddy = dog("Buddy") {
            age(4)
            goldenRetriever()
        }

        val skipper = dog("Skipper") {
            hair(10)
        }

        assertEquals(Dog("Ole Boy", 3, Breed.SNICKERDOODLE, HairLength.LONG), oleBoy)

        assertEquals(Dog("Buddy", 4, Breed.GOLDEN_RETRIEVER, HairLength.SHORT), buddy)

        assertEquals(Dog("Skipper", 1, Breed.GREYHOUND, HairLength.LONG), skipper)
    }

}