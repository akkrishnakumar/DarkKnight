sealed class Moves

class Restricted(val steps: Int) : Moves()
object Unlimited : Moves()

sealed class Piece(val moves: Moves) {
    abstract val position: String
    abstract val directions: List<Direction>
}

data class King(override val position: String) : Piece(Restricted(1)) {
    override val directions: List<Direction> =
        listOf(
            Direction.T,
            Direction.TR,
            Direction.R,
            Direction.BR,
            Direction.B,
            Direction.BL,
            Direction.L,
            Direction.TL
        )
}

data class Knight(override val position: String) : Piece(Restricted(2)) {
    override val directions: List<Direction> =
        listOf(
            Direction.TLL,
            Direction.TLR,
            Direction.BLL,
            Direction.BLR
        )
}

data class Queen(override val position: String) : Piece(Unlimited) {
    override val directions: List<Direction> =
        listOf(
            Direction.T,
            Direction.TR,
            Direction.R,
            Direction.BR,
            Direction.B,
            Direction.BL,
            Direction.L,
            Direction.TL
        )
}

data class Bishop(override val position: String) : Piece(Unlimited) {
    override val directions: List<Direction> =
        listOf(
            Direction.TR,
            Direction.BR,
            Direction.BL,
            Direction.TL
        )
}

data class Rook(override val position: String) : Piece(Unlimited) {
    override val directions: List<Direction> =
        listOf(
            Direction.T,
            Direction.R,
            Direction.B,
            Direction.L,
        )
}