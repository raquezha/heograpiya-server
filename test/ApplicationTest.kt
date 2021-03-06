import com.raquezha.module
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

@KtorExperimentalLocationsAPI
class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }
        }
    }
}
