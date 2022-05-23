/**
 * 26. Remove emphasis markups
 * In addition to the process of the problem 25, remove emphasis MediaWiki markups from the values. See Help:Cheatsheet.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val text = ukPage.text
    val infoBoxRegex =
        """^\{\{Infobox country$(.*?)^}}$""".toRegex(setOf(RegexOption.MULTILINE, RegexOption.DOT_MATCHES_ALL))
    val infoboxText = infoBoxRegex
        .find(text)?.value
        ?: throw Exception("Infobox not found")

    val elementRegex = """^\|\s(.*?)\s+=\s?(.*?)$""".toRegex(setOf(RegexOption.MULTILINE, RegexOption.DOT_MATCHES_ALL))
    elementRegex.findAll(infoboxText)
        .map { it.groupValues[1] to it.groupValues[2] }
        .map { it.first to it.second.replace("''", "") }
        .forEach { println("${it.first} => ${it.second}") }
}