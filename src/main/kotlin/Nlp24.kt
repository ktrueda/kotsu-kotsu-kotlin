/**
 * 24. Media references
 * Extract references to media files linked from the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val text = ukPage.text
//    println(text)
    val refRegex = "\\[\\[File:(.*)]]".toRegex()
    val answer = refRegex
        .findAll(text)
        .map { it.value.trim() }
        .forEach { println(it) }
}
