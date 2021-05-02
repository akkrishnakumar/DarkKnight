import Direction.Direction
import Direction.Direction.*

sealed class Moves

class Restricted(val steps: Int) : Moves()
object Unlimited : Moves()

sealed class Piece(val moves: Moves) {
    abstract val position: String
    abstract val directions: List<Direction>
}

data class King(override val position: String) : Piece(Restricted(1)) {
    override val directions: List<Direction> =
        listOf(T, TR, R, BR, B, BL, L, TL)
}
