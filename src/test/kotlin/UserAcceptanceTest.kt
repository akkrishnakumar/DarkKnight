import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class UserAcceptanceTest {

    private val board = DefaultBoard(8, 8)

    @Test
    fun `King can move one step in all directions`() {
        val expected = listOf("E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4")

        val input = "King D5"
        val actual = board.showMoves(input).successValue()

        assertThat(actual, equalTo(expected))
    }

    @Test
    fun `Knight can move 3 steps in a 'L' shape direction`() {
        val expected = listOf("G4", "F5", "D5", "C4", "C2", "D1", "F1")
        val input = "Knight E3"

        val actual = board.showMoves(input).successValue()

        assertThat(actual, equalTo(expected))
    }

}

