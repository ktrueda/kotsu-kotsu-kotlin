/**
 * 08. cipher text
 * Implement a function cipher that converts a given string with the specification:
 * Every alphabetical lowercase letter c is converted to a letter whose ASCII code is (219 - [the ASCII code of c])
 * Keep other letters unchanged
 * Use this function to cipher and decipher an English message.
 */
fun main() {
    val text = "oriGiNal Text"
    val ciphered = cipher(text)
    val deciphered = decipher(ciphered)

    println(ciphered)
    println(deciphered)
}

const val LowerMin = 'a'.code
const val LowerMax = 'z'.code

const val CipheredLowerMin = 219 - 'z'.code
const val CipheredLowerMax = 219 - 'a'.code

fun cipher(plain: String): String = plain
    .map { c ->
        if (c.code in LowerMin..LowerMax) {
            (219 - c.code).toChar()
        } else {
            c
        }
    }.joinToString("")

fun decipher(ciphered: String): String = ciphered
    .map { c ->
        if (c.code in CipheredLowerMin..CipheredLowerMax) {
            (219 - c.code).toChar()
        } else {
            c
        }
    }
    .joinToString("")