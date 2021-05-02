import com.natpryce.hamkrest.MatchResult
import com.natpryce.hamkrest.MatchResult.Match
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class MatchersTest {

    @Test
    internal fun `should return Match if the contents in the list are equal`() {
        val expectedList = listOf("1", "2", "3")
        val actualList = listOf("3", "2", "1")

        assertMatch(containsAllOf(expectedList)(actualList))
    }

    @Test
    internal fun `should return MisMatch if the contents in the list are not equal`() {
        val expectedList = listOf("1", "2", "3")
        val actualList = listOf("A", "B", "C")

        assertMisMatch(containsAllOf(expectedList)(actualList))
    }

    private fun assertMatch(result: MatchResult) = assertEquals(Match, result)

    private fun assertMisMatch(result: MatchResult) = assertNotEquals(Match, result)
}