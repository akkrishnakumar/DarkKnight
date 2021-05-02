typealias GameLogic = (Piece) -> List<String>

class DefaultGameLogic(val rowNum: Int, val colNum: Int) : GameLogic {

    private val cells = (1..rowNum)
        .map { (it + 64).toChar() }
        .flatMap { (1..colNum).map { row -> "$it$row" } }

    override fun invoke(piece: Piece): List<String> = piece.possibleMoves()

    private fun Piece.possibleMoves(): List<String> {
        val curr = cells.indexOf(position)
        return (1..moves.steps())
            .flatMap { increment ->
                val iterator = colNum * increment
                directions
                    .map { getCell(it.formula(curr, iterator, increment, moves.steps())) }
                    .filter { it != "" }
            }
    }

    private fun getCell(index: Int) = cells.getOrElse(index, ::defaultValue)

    private fun Moves.steps() = when (this) {
        is Restricted -> steps
        Unlimited     -> rowNum
    }

    private fun defaultValue(value: Int) = ""

    private fun Direction.formula(curr: Int, iterator: Int, increment: Int, moves: Int) =
        when (this) {
            Direction.TL  -> tlCondition(curr, iterator, increment)
            Direction.T   -> curr + iterator
            Direction.TR  -> curr + (iterator + increment)
            Direction.L   -> leftEdgeCondition(curr, increment)
            Direction.R   -> rightEdgeCondition(curr, increment)
            Direction.BL  -> curr - (iterator + increment)
            Direction.B   -> curr - iterator
            Direction.BR  -> brCondition(curr, iterator, increment)
            Direction.TLL -> (curr + (moves - increment) + iterator + 1)
            Direction.TLR -> (curr - (moves - increment) + iterator - 1)
            Direction.BLL -> (curr + (moves - increment) - iterator + 1)
            Direction.BLR -> (curr - (moves - increment) - iterator - 1)
        }

    private fun leftEdgeCondition(curr: Int, increment: Int): Int {
        val pos = curr - (1 * increment)
        return if (pos.row() >= curr.row()) pos else -1
    }

    private fun rightEdgeCondition(curr: Int, increment: Int): Int {
        val pos = curr + (1 * increment)
        return if (pos.row() <= curr.row()) pos else -1
    }

    private fun brCondition(curr: Int, iterator: Int, increment: Int): Int {
        val pos = curr - (iterator - increment)
        return if (pos == 0) -1 else pos
    }

    private fun tlCondition(curr: Int, iterator: Int, increment: Int): Int {
        val pos = curr + (iterator - increment)
        return if (pos == cells.size - 1) -1 else pos
    }

    private fun Int.row() = this / colNum

}

