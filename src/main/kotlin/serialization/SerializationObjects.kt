package serialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project(val name: String = "project", val language: String = "java"){
    init {
        require(name.isNotEmpty()){"name must not be empty"}
    }
}

@Serializable
class Box<T>(val contents: T)


private val dateRegex = Regex("[0-9]{2}-[0-9]{2}-[0-9]{4}")

@Serializable
data class DateHolder(val date: String) {
    init {
        require(dateRegex.matches(date))
    }
}

@Serializable
sealed interface Pet

@Serializable
@SerialName("Dog")
data class Dog(val breed: String): Pet

@Serializable
@SerialName("Cat")
class Cat(val color: String): Pet

@Serializable
data class House(val pets: List<Pet>) {
    init {
        require(pets.filterIsInstance<Cat>().isNotEmpty())
    }
}