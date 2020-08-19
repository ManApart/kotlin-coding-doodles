fun doThing(pixel: Pixel) : Boolean {
    val x = pixel.x
    pixel.index = 10
    return false
}

fun transformList(list: List<String>, transformation: (String) -> String) : List<String> {
    return list.map { transformation(it) }
}

fun useMeWithoutAClass() {

}

fun evaluate(number: Int, specialCase: Boolean): String {
    return when {
        number <= 0 -> "Bad Value"
        number == 1 && specialCase -> "Special number one!"
        number == 1 -> "Single"
        number == 2 -> "Double"
        else -> "Default"
    }
}


fun evaluate(number: Int): String {
    return when (number) {
        1 -> "Single"
        2 -> "Double"
        else -> "Default"
    }
}