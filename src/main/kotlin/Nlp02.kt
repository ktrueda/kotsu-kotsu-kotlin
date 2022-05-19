/**
 * 02. “shoe” + “cold” = “schooled”Permalink
 * Obtain the string “schooled” by concatenating the letters in “shoe” and “cold” one after the other from head to tail.
 */
fun main() {
    val text1 = "shoe"
    val text2 = "cold"

    println(text1.zip(text2) { a, b -> listOf(a, b) }.flatten().joinToString(""))
}