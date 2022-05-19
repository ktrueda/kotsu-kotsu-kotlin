/**
 * 05. n-gramPermalink
 * Implement a function that obtains n-grams from a given sequence object (e.g., string and list). Use this function to
 * obtain word bi-grams and letter bi-grams from the sentence “I am an NLPer”
 */
fun main() {
    val text = "I am an NLPer"
    val words = text.split(" ")

    println(ngram(words, 2))
    println(ngram(text.toList(), 2))


}

fun <T> ngram(input: List<T>, n: Int): List<T> {
    val size = input.size
    return IntRange(0, size - n)
        .map { e -> input.subList(e, e + n) }
        .flatten()
}