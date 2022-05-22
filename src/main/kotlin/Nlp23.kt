/**
 * 23. Section structure
 * Extract section names in the article with their levels. For example, the level of the section is 1 for the MediaWiki
 * markup "== Section name ==".
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    println(ukPage.text)
    val sectionRegex = "^(={1,3})+(\\w*)(={1,3})$".toRegex(RegexOption.MULTILINE)
    sectionRegex
        .findAll(ukPage.text)
        .map {
            Section(
                name = it.groupValues[2],
                level = 4 - it.groupValues[1].length
            )
        }
        .forEach { println(it) }
}

data class Section(val name: String, val level: Int)