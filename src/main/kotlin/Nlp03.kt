/**
 * 03. PiPermalink
 * Split the sentence “Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics”.
 * into words, and create a list whose element presents the number of alphabetical letters in the corresponding word.
 */
fun main() {
    val text = "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics"

    println(text.split(" ").map { it.length })

}