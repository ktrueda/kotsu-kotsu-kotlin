/**
 * 01. “schooled”Permalink
 * Obtain the string that concatenates the 1st, 3rd, 5th, and 7th letters in the string “schooled”.
 */
fun main() {
    val originalText = "schooled"
    val extracted = listOf(1, 3, 5, 7).map { originalText[it] }
        .fold("") { acc, c -> acc + c }
    println(extracted)
}