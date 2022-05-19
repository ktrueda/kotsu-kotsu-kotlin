/**
 * 07. Template-based sentence generationPermalink
 * Implement a function that receives arguments, x, y, and z and returns a string “{y} is {z} at {x}”, where “{x}”, “{y}”,
 * and “{z}” denote the values of x, y, and z, respectively. In addition, confirm the return string by giving the arguments
 * x=12, y="temperature", and z=22.4.
 */
fun main() {
    println(fun07("12", "temperature", "22.4"))
}

fun fun07(x: String, y: String, z: String) = "$y is $z at $x"