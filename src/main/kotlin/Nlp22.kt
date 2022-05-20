/**
 * 22. Category namesPermalink
 * Extract the category names of the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val categoryLines = ukPage.text
        .split("\n")
        .filter { it.startsWith("[[Category:") }
        .map {
            "\\[\\[Category:(.*)\\]\\]".toRegex()
                .find(it)!!.groups[1]!!.value.replace("|", "")
        }
    println(categoryLines)
}