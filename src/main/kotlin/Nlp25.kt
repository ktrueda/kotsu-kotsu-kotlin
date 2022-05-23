/**
 * 25. Infobox
 * Extract field names and their values in the Infobox “country”, and store them in a dictionary object.
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
    val answer = elementRegex.findAll(infoboxText)
        .map { it.groupValues[1] to it.groupValues[2] }
        .toMap()
    println(answer)
}