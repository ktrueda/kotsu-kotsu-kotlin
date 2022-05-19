/**
 * 09. Typoglycemia
 * Write a program with the specification:
 * - Receive a word sequence separated by space
 * - For each word in the sequence:
 *     - If the word is no longer than four letters, keep the word unchanged
 *     - Otherwise,
 *         - Keep the first and last letters unchanged
 *         - Shuffle other letters in other positions (in the middle of the word)
 * Observe the result by giving a sentence, e.g., “I couldn’t believe that I could actually understand what I was
 * reading : the phenomenal power of the human mind “.
 */
fun main() {
    val text =
        "I couldn’t believe that I could actually understand what I was reading : the phenomenal power of the human mind"

    println(fun09(text))

}

fun CharSequence.shuffle(): String {
    return this.toList().shuffled().toCharArray().joinToString("")
}

fun fun09(text: String): String = text.split(" ")
    .map { e ->
        if (e.length <= 4) {
            e
        } else {
            e[0].toString() + e.subSequence(1, e.length - 1).shuffle() + e[e.length - 1].toString()
        }
    }.joinToString(" ")
