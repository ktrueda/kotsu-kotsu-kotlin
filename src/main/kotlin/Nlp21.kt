/**
 * 21. Lines with category names
 * Extract lines that define the categories of the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
//    println(ukPage.text)
    val categoryRegex = Regex("\\[\\[Category:(.*)\\]\\]*")
    val categoryLines = ukPage.text
        .split("\n")
        .filter { categoryRegex.matches(it) }
    println(categoryLines)
}