import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class InputParserTest {

    private val parser = DefaultInputParser()

    @Test
    internal fun `should return success result with Piece when input is valid`() {
        val expected = King("D5")
        val input = "King D5"

        val actual = parser(input).successValue()

        assertThat(actual, equalTo(expected))
    }

    @Test
    internal fun `should return Failure when input is not valid`() {
        val input = "invalid input"
        val expected = ParsingError(input)

        val actual = parser(input)

        assertThat(actual, equalTo(expected))
    }
}