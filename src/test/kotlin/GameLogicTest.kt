import com.natpryce.hamkrest.assertion.assertThat
import org.junit.jupiter.api.Test

class GameLogicTest {

    val gameLogic = DefaultGameLogic(8, 8)

    @Test
    internal fun `should return possible moves for King`() {
        val expected = listOf("E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4")
        val input = King("D5")

        val actual = gameLogic(input)

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    internal fun `should return possible moves for Knight`() {
        val expected = listOf("G4", "F5", "D5", "C4", "C2", "D1", "F1", "G2")
        val input = Knight("E3")

        val actual = gameLogic(input)

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    internal fun `should return possible moves for Queen`() {
        val expected = listOf(
            "E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4",
            "F5", "F7", "D7", "B7", "B5", "B3", "D3", "F3",
            "G5", "G8", "D8", "A8", "A5", "A2", "D2", "G2",
            "H5", "D1", "H1"
        )
        val input = Queen("D5")

        val actual = gameLogic(input)

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    internal fun `should return possible moves for Knight in corner`() {
        val expected = listOf("H4", "F4", "E1", "E3")
        val input = Knight("G2")

        val actual = gameLogic(input)

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    internal fun `should return possible moves for Bishop`() {
        val expected = listOf(
            "E4", "E6", "C6", "C4",
            "F3", "F7", "B7", "B3",
            "G2", "G8", "A8", "A2",
            "H1"
        )
        val input = Bishop("D5")

        val actual = gameLogic(input)

        assertThat(actual, containsAllOf(expected))
    }
}