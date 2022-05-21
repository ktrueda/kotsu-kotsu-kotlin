/**
 * 24. Media referencesPermalink
 * Extract references to media files linked from the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val text = ukPage.text
    val refRegex = "(https|http)://[0-9a-zA-Z\\./]* ".toRegex()
    val answer = refRegex.findAll(text)
        .map { it.value.trim() }
        .toList()
    println(answer)
}
