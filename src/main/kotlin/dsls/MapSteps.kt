package dsls

data class NamedThing(var name: String = "", var age: Int? = null)

fun getOlder(person: NamedThing, amount: Int) {
    person.age = (person.age ?: 0) + amount
}

fun NamedThing.getOlder2(amount: Int) {
    this.age = (age ?: 0) + amount
}

fun addOne(numbers: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (number in numbers){
        result.add(number + 1)
    }
    return result
}

fun List<Int>.addOne2(): List<Int> {
    val result = mutableListOf<Int>()
    for (number in this){
        result.add(number + 1)
    }
    return result
}

fun List<Int>.addAmount(amount: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (number in this){
        result.add(number + amount)
    }
    return result
}

fun List<Int>.updateList(transform: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (number in this){
        result.add(transform(number))
    }
    return result
}

fun <T> List<T>.updateGeneric(transform: (T) -> T): List<T> {
    val result = mutableListOf<T>()
    for (number in this){
        result.add(transform(number))
    }
    return result
}

fun <T, R> List<T>.updateGeneric2(transform: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (number in this){
        result.add(transform(number))
    }
    return result
}