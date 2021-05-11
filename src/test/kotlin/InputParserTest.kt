import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource


class InputParserTest {

    private val parser = DefaultInputParser()

    @ParameterizedTest
    @MethodSource("validInputCombinations")
    internal fun `should return success result with Piece when input is valid`(
        input: String,
        expected: Piece
    ) {
        val actual = parser(input).successValue()

        assertThat(actual, equalTo(expected))
    }

    @Test
    internal fun `should return Failure when input is not valid`() {
        val input = "invalid input"
        val expected = ParsingError(input)

        val actual = parser(input).failureValue()

        assertThat(actual, equalTo(expected))
    }

    companion object {

        @JvmStatic
        fun validInputCombinations() = listOf(
            of("King D5", King("D5")),
            of("Queen D5", Queen("D5")),
            of("Bishop D5", Bishop("D5")),
        )
    }
}