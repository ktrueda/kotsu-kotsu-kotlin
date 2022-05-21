/**
 * 22. Category namesPermalink
 * Extract the category names of the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val categoryRegex = "^\\[\\[Category:(.*?)(?:\\|.*)?\\]\\]$".toRegex(RegexOption.MULTILINE)
    categoryRegex
        .findAll(ukPage.text)
        .map { it.groupValues[1] }
        .forEach { println(it) }
}