/**
 * 25. Infobox
 * Extract field names and their values in the Infobox “country”, and store them in a dictionary object.
 */
fun main() {
    val wikiPages = fetchEnWikiCountries()
    val ukPage = wikiPages["United Kingdom"]!!
    val text = ukPage.text
//    println(text)
    val infoRegex = "\\{\\{Infobox[a-zA-Z0-9\\S\\s\\n\\r]*}}".toRegex()
    val infoBoxText = infoRegex.find(text)!!.value
    println(infoBoxText)
}