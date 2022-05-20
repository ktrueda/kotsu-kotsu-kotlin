/**
 * 21. Lines with category names
 * Extract lines that define the categories of the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val categoryLines = ukPage.text
        .split("\n")
        .filter { it.startsWith("[[Category:") }
    println(categoryLines)
}