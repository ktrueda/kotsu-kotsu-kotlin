/**
 * 04. Atomic symbolsPermalink
 * Split the sentence “Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security
 * Clause. Arthur King Can”. into words, and extract the first letter from the 1st, 5th, 6th, 7th, 8th, 9th, 15th, 16th,
 * 19th words and the first two letters from the other words. Create an associative array (dictionary object or mapping
 * object) that maps from the extracted string to the position (offset in the sentence) of the corresponding word.
 */
fun main() {
    val text =
        "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can"

    val indexFor1st = setOf(1, 5, 6, 7, 8, 9, 15, 16, 19)

    val answer = text.split(" ")
        .mapIndexed { index, s ->
            val indexStartFrom1 = index + 1
            if (indexFor1st.contains(indexStartFrom1)) indexStartFrom1 to s.subSequence(0, 1)
            else indexStartFrom1 to s.subSequence(0, 2)
        }.toMap()
    println(answer)

}