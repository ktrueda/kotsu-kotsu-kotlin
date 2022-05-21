/**
 * 22. Category namesPermalink
 * Extract the category names of the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
//    println(ukPage.text)
    val categoryRegex = Regex("\\[\\[Category:(.*)\\]\\]*")
    val categoryLines = ukPage.text
        .split("\n")
        .filter { categoryRegex.matches(it) }
        .map {
            "\\[\\[Category:(.*)\\]\\]".toRegex()
                .find(it)!!.groups[1]!!.value.replace("|", "")
        }
    println(categoryLines)
}