/**
 * 06. SetPermalink
 * Let the sets of letter bi-grams from the words “paraparaparadise” and “paragraph” $X$ and $Y$, respectively. Obtain
 * the union, intersection, difference of the two sets. In addition, check whether the bigram “se” is included in the
 * sets $X$ and $Y$
 */
fun main() {
    val x = ngramChar("paraparaparadise".toList(), 2).toSet()
    val y = ngramChar("paragraph".toList(), 2).toSet()

    println("x: $x")
    println("y: $y")

    println("x.union(y): ${x.union(y)}")
    println("x.intersect(y): ${x.intersect(y)}")
    println("x - y: ${x - y}")
    println("x.contains(\"se\"):  ${x.contains("se")}")
    println("y.contains(\"se\"):  ${y.contains("se")}")
}