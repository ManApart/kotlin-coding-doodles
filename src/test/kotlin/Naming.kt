import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Naming {

    @Test
    fun itDoesThThing(){

    }

    @Test
    fun testGetTheFruit(){

    }

    @Test
    fun getTheFruitTest(){

    }

    @Test
    fun testGetRedAppleEquals(){

    }

    @Test
    fun addApple(){
        val subject = Basket()
        subject.addApple(1)

        assertEquals(1, subject.getFruitCount(FruitType.APPLE))
    }

    @Test
    fun addApple2(){
        val bskt = Basket()
        bskt.addApple(1)

        assertEquals(1, bskt.getFruitCount(FruitType.APPLE))
    }

    @Test
    fun assertTools(){
        val a: String? = "thingy"
        val b: String? = null

        assertFalse(a.equals(b))
        assertTrue(a != null)
        assertFalse(a == b)

    }



}