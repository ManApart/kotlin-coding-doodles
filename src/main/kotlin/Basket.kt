enum class FruitType { APPLE, ORANGE}

class Basket {
    private val contents = mutableMapOf<FruitType, Int>()

    fun addApple(amount: Int){
        contents.putIfAbsent(FruitType.APPLE, 0)
        contents[FruitType.APPLE] = getFruitCount(FruitType.APPLE) + amount
    }

    fun addOrange(amount: Int){
        contents.putIfAbsent(FruitType.ORANGE, 0)
        contents[FruitType.ORANGE] = getFruitCount(FruitType.ORANGE) + amount
    }

    fun getFruitCount(type: FruitType): Int {
        return contents[type] ?: 0
    }
}