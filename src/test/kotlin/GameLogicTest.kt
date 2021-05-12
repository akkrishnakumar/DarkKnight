import com.natpryce.hamkrest.assertion.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class GameLogicTest {

    val gameLogic = DefaultGameLogic(8, 8)

    @ParameterizedTest
    @MethodSource("possibleOutcomesForKing")
    internal fun `should return possible moves for King`(input: Piece, expected: List<String>) {
        val actual = gameLogic(input)
        assertThat(actual, containsAllOf(expected))
    }

    @ParameterizedTest
    @MethodSource("possibleOutcomesForKnight")
    internal fun `should return possible moves for Knight`(input: Piece, expected: List<String>) {
        val actual = gameLogic(input)
        assertThat(actual, containsAllOf(expected))
    }

    @ParameterizedTest
    @MethodSource("possibleOutcomesForQueen")
    internal fun `should return possible moves for Queen`(input: Piece, expected: List<String>) {
        val actual = gameLogic(input)
        assertThat(actual, containsAllOf(expected))
    }

    @ParameterizedTest
    @MethodSource("possibleOutcomesForBishop")
    internal fun `should return possible moves for Bishop`(input: Piece, expected: List<String>) {
        val actual = gameLogic(input)
        assertThat(actual, containsAllOf(expected))
    }

    @ParameterizedTest
    @MethodSource("possibleOutcomesForRook")
    internal fun `should return possible moves for Rook`(input: Piece, expected: List<String>) {
        val actual = gameLogic(input)
        assertThat(actual, containsAllOf(expected))
    }

    @Test
    internal fun `should return possible moves for Pawn`() {
        val expected = listOf("E5")
        val input = Pawn("D5")

        val actual = gameLogic(input)

        assertThat(actual, containsAllOf(expected))
    }

    companion object {

        @JvmStatic
        fun possibleOutcomesForKing() = listOf(
            of(King("A1"), listOf("B1", "B2", "A2")),
            of(King("A8"), listOf("B8", "B7", "A7")),
            of(King("D5"), listOf("E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4")),
            of(King("H1"), listOf("H2", "G2", "G1")),
            of(King("H8"), listOf("H7", "G7", "G8")),
        )

        @JvmStatic
        fun possibleOutcomesForKnight() = listOf(
            of(Knight("A1"), listOf("C2", "B3")),
            of(Knight("A8"), listOf("C7", "B6")),
            of(Knight("E3"), listOf("G4", "F5", "D5", "C4", "C2", "D1", "F1", "G2")),
            of(Knight("H1"), listOf("F2", "G3")),
            of(Knight("H8"), listOf("F7", "G6")),
        )

        @JvmStatic
        fun possibleOutcomesForQueen() = listOf(
            of(
                Queen("A1"), listOf(
                    "B1", "C1", "D1", "E1", "F1", "G1", "H1",
                    "A2", "A3", "A4", "A5", "A6", "A7", "A8",
                    "B2", "C3", "D4", "E5", "F6", "G7", "H8"
                )
            ),
            of(
                Queen("A8"), listOf(
                    "B8", "C8", "D8", "E8", "F8", "G8", "H8",
                    "A1", "A2", "A3", "A4", "A5", "A6", "A7",
                    "B7", "C6", "D5", "E4", "F3", "G2", "H1"
                )
            ),
            of(
                Queen("D5"), listOf(
                    "E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4",
                    "F5", "F7", "D7", "B7", "B5", "B3", "D3", "F3",
                    "G5", "G8", "D8", "A8", "A5", "A2", "D2", "G2",
                    "H5", "D1", "H1"
                )
            ),
            of(
                Queen("H1"), listOf(
                    "A1", "B1", "C1", "D1", "E1", "F1", "G1",
                    "H2", "H3", "H4", "H5", "H6", "H7", "H8",
                    "A8", "B7", "C6", "D5", "E4", "F3", "G2"
                )
            ),
            of(
                Queen("H8"), listOf(
                    "A8", "B8", "C8", "D8", "E8", "F8", "G8",
                    "H1", "H2", "H3", "H4", "H5", "H6", "H7",
                    "A1", "B2", "C3", "D4", "E5", "F6", "G7"
                )
            )
        )

        @JvmStatic
        fun possibleOutcomesForBishop() = listOf(
            of(
                Bishop("A1"), listOf(
                    "B2", "C3", "D4", "E5", "F6", "G7", "H8"
                )
            ),
            of(
                Bishop("A8"), listOf(
                    "B7", "C6", "D5", "E4", "F3", "G2", "H1"
                )
            ),
            of(
                Bishop("D5"), listOf(
                    "E4", "E6", "C6", "C4",
                    "F3", "F7", "B7", "B3",
                    "G2", "G8", "A8", "A2",
                    "H1"
                )
            ),
            of(
                Bishop("H1"), listOf(
                    "A8", "B7", "C6", "D5", "E4", "F3", "G2"
                )
            ),
            of(
                Bishop("H8"), listOf(
                    "A1", "B2", "C3", "D4", "E5", "F6", "G7"
                )
            )
        )

        @JvmStatic
        fun possibleOutcomesForRook() = listOf(
            of(
                Rook("A1"), listOf(
                    "B1", "C1", "D1", "E1", "F1", "G1", "H1",
                    "A2", "A3", "A4", "A5", "A6", "A7", "A8",
                )
            ),
            of(
                Rook("A8"), listOf(
                    "B8", "C8", "D8", "E8", "F8", "G8", "H8",
                    "A1", "A2", "A3", "A4", "A5", "A6", "A7",
                )
            ),
            of(
                Rook("D5"), listOf(
                    "E5", "F5", "G5", "H5",
                    "D6", "D7", "D8",
                    "C5", "B5", "A5",
                    "D4", "D3", "D2", "D1"
                )
            ),
            of(
                Rook("H1"), listOf(
                    "A1", "B1", "C1", "D1", "E1", "F1", "G1",
                    "H2", "H3", "H4", "H5", "H6", "H7", "H8",
                )
            ),
            of(
                Rook("H8"), listOf(
                    "A8", "B8", "C8", "D8", "E8", "F8", "G8",
                    "H1", "H2", "H3", "H4", "H5", "H6", "H7",
                )
            )
        )

    }

}