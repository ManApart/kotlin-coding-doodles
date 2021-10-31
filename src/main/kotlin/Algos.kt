fun reverse(line: String): String {
    val size = line.length-1
    return (0..size).map { line[size-it] }.joinToString("")
}