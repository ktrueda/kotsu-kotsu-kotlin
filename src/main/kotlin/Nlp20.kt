import com.github.kittinunf.fuel.httpGet
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.charset.StandardCharsets.UTF_8
import java.util.zip.GZIPInputStream

/**
 * 20. Read JSON documents
 * Read the JSON documents and output the body of the article about the United Kingdom. Reuse the output in problems 21-29.
 */
const val JSON_URL = "https://nlp100.github.io/data/enwiki-country.json.gz"
fun main() {
    val wikiPages = fetchEnWikiCountries()
    println(wikiPages["United Kingdom"])
}

fun fetchEnWikiCountries(): Map<String, WikiPage> {
    val response = JSON_URL.httpGet().response().second
    val unzipped = GZIPInputStream(response.data.inputStream())
        .bufferedReader(UTF_8)
        .use { it.readText() }
    return unzipped.split("\n")
        .filter { it != "" }
        .map {
            val obj = Json.decodeFromString<WikiPage>(it)
            obj.title to obj
        }.toMap()
}

@kotlinx.serialization.Serializable
data class WikiPage(val title: String, val text: String)