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

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    fun `Knight can move 3 steps in a 'L' shape direction towards top and bottom`() {
        val expected = listOf("G4", "F5", "D5", "C4", "C2", "D1", "F1", "G2")
        val input = "Knight E3"

        val actual = board.showMoves(input).successValue()

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    fun `Queen can move across the board is all 8 directions`() {
        val expected = listOf(
            "E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4",
            "F5", "F7", "D7", "B7", "B5", "B3", "D3", "F3",
            "G5", "G8", "D8", "A8", "A5", "A2", "D2", "G2",
            "H5", "D1", "H1"
        )
        val input = "Queen D5"

        val actual = board.showMoves(input).successValue()

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    fun `Bishop can move across the board only diagonally`() {
        val expected = listOf(
            "E4", "E6", "C6", "C4",
            "F3", "F7", "B7", "B3",
            "G2", "G8", "A8", "A2",
            "H1"
        )
        val input = "Bishop D5"

        val actual = board.showMoves(input).successValue()

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    fun `Rook can move across the board only vertically and horizontally`() {
        val expected = listOf(
            "E5", "F5", "G5", "H5",
            "D6", "D7", "D8",
            "C5", "B5", "A5",
            "D4", "D3", "D2", "D1"
        )
        val input = "Rook D5"

        val actual = board.showMoves(input).successValue()

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    fun `Pawn can move only 1 step at a time, in the forward direction, vertically`() {
        val expected =  listOf("E5")
        val input = "Pawn D5"

        val actual = board.showMoves(input).successValue()

        assertThat(actual, containsAllOf(expected))
    }

    @Test
    fun `Show Error message when wrong input is entered`() {
        val expected = ParsingError("Wrong Input")
        val input = "Wrong Input"

        val actual = board.showMoves(input).failureValue()

        assertThat(actual, equalTo(expected))
    }
}

