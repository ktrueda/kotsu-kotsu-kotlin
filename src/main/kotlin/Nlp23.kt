/**
 * 23. Section structure
 * Extract section names in the article with their levels. For example, the level of the section is 1 for the MediaWiki
 * markup "== Section name ==".
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val sectionNames = ukPage.text
        .split("\n")
        .filter {
            "=(.*)=".toRegex().matches(it)
        }
        .mapNotNull {
            when {
                it.startsWith("===") -> Section(it.substring(3, it.length - 3), 3)
                it.startsWith("==") -> Section(it.substring(2, it.length - 2), 2)
                it.startsWith("=") -> Section(it.substring(1, it.length - 1), 1)
                else -> null
            }
        }

    println(sectionNames)
}

data class Section(val name: String, val level: Int)