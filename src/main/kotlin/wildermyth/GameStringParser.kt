package wildermyth

fun Character.interpolate(line: String): String {
    val (templates, parts) = identifyTemplates(line)
    println("templates: $templates")
    println("parts: $parts")
    val interpolated = templates.map { this.replaceTemplate(it) }

    return parts.indices.joinToString("") { i ->
        parts[i] + (interpolated.getOrNull(i) ?: "")
    }
}

private fun Character.replaceTemplate(template: String): String {
    return when {
        template == "<name>" -> name
        else -> template
    }
}

private fun identifyTemplates(line: String): Pair<List<String>, List<String>>{
    val chunks = mutableListOf<Pair<Int, Int>>()
    var current = findToken(line, 0)
    while(current != null){
        chunks.add(current)
        current = findToken(line, chunks.last().second)
    }

    val parts = mutableListOf<String>()
    var i = 0
    val templates = chunks.map { (start, end) ->
        parts.add(line.substring(i, start))
        i = end
        line.substring(start, end)
    }
    parts.add(line.substring(i, line.length))

    return templates to parts
}

private fun findToken(line: String, from: Int): Pair<Int, Int>? {
    val start = line.indexOf("<", from)
    val end = line.indexOf(">", start)+1
    return if (start == -1 || end == -1) null else start to end
}