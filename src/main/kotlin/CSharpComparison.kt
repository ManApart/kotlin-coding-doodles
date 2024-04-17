
fun mediaTypes(): String {
    val mediaTypes = listOf("application/json;thing", "text/*;other")
    val jsonTypes = listOf("application/json")
    val htmlTypes = listOf("text/html")

    return mediaTypes
        .map { it.split(";")[0].lowercase() }
        .firstNotNullOfOrNull { type ->
            when (type) {
                in jsonTypes -> "application/json"
                in htmlTypes -> "text/html"
                else -> null
            }
        } ?: ""
 }