/**
 * 21. Lines with category names
 * Extract lines that define the categories of the article.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
//    println(ukPage.text)
    val categoryRegex = "^\\[\\[Category:.*$".toRegex(RegexOption.MULTILINE)
//    println("##############")
    categoryRegex
        .findAll(ukPage.text)
        .forEach { println(it.value) }
}