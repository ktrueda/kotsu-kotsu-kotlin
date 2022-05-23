/**
 * 27. Remove internal links
 * In addition to the process of the problem 26, remove internal links from the values. See Help:Cheatsheet.
 */
internal val internalLinkRegex = """\[\[(.*?)]]""".toRegex()
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
        .map { it.first to internalLinkRegex.replace(it.second) { it.groupValues[1] } }
        .forEach { println("${it.first} => ${it.second}") }
}
