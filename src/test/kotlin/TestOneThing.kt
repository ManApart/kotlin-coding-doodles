import org.testng.annotations.Test
import kotlin.test.assertEquals

class TestOneThing {

    @Test
    fun addFruit() {
        val basket = Basket()
        basket.addApple(1)
        basket.addOrange(2)

        assertEquals(1, basket.getFruitCount(FruitType.APPLE))
        assertEquals(2, basket.getFruitCount(FruitType.ORANGE))
    }

    @Test
    fun addApple() {
        val basket = Basket()
        basket.addApple(1)

        assertEquals(1, basket.getFruitCount(FruitType.APPLE))
    }

    @Test
    fun addOrange() {
        val basket = Basket()
        basket.addOrange(2)

        assertEquals(2, basket.getFruitCount(FruitType.ORANGE))
    }

}