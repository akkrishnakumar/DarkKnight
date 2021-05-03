import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class ConsoleTest {

    private val consoleApp = ConsoleApp({ "Input" }, ::println)

    @Test
    internal fun `should print possible positions of given piece on console`() {
        val expected = "E5, E6, D6, C6, C5, C4, D4, E4"
        val input = "King D5"

        val actual: String = TODO()

        assertThat(actual, equalTo(expected))
    }
}