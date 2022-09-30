package dsls


enum class Breed { GREYHOUND, GOLDEN_RETRIEVER, SNICKERDOODLE }
enum class HairLength { SHORT, MEDIUM, LONG }
data class Dog(val name: String, val age: Int, val breed: Breed, val hairLength: HairLength)


class DogBuilder(private val name: String) {
    private var age = 1
    private var breed = Breed.GREYHOUND
    private var hairLength = HairLength.MEDIUM

    fun age(age: Int){
        this.age = age
    }

    fun breed(breed: Breed){
        this.breed = breed
    }

    fun hair(length: HairLength){
        this.hairLength = length
    }

    fun hair(length: Int){
        this.hairLength = when {
            length < 3 -> HairLength.SHORT
            length in 3..7 -> HairLength.MEDIUM
            else -> HairLength.LONG
        }
    }

    fun goldenRetriever() {
        this.breed = Breed.GOLDEN_RETRIEVER
        this.hairLength = HairLength.SHORT
    }

    fun build(): Dog {
        return Dog(name, age, breed, hairLength)
    }
}

fun dog(name: String, customizer: DogBuilder.() -> Unit): Dog {
    return DogBuilder(name).apply(customizer).build()
}

open class Element(val children: MutableList<Element> = mutableListOf())

class HTML(val children: MutableList<Element> = mutableListOf()) {
    fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }
}

class Body : Element()


fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

