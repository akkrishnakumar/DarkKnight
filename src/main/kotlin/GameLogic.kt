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
            Direction.TR  -> trCondition(curr, iterator, increment)
            Direction.L   -> leftEdgeCondition(curr, increment)
            Direction.R   -> rightEdgeCondition(curr, increment)
            Direction.BL  -> blCondition(curr, iterator, increment)
            Direction.B   -> curr - iterator
            Direction.BR  -> brCondition(curr, iterator, increment)
            Direction.TLL -> ttlCondition(curr, iterator, increment, moves)
            Direction.TLR -> ttrCondition(curr, iterator, increment, moves)
            Direction.BLL -> bllCondition(curr, iterator, increment, moves)
            Direction.BLR -> blrCondition(curr, iterator, increment, moves)
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
        return if ((curr - iterator).row() == pos.row() && pos != 0) pos else -1
    }

    private fun blCondition(curr: Int, iterator: Int, increment: Int): Int {
        val pos = curr - (iterator + increment)
        return if ((curr - iterator).row() == pos.row()) pos else -1
    }

    private fun trCondition(curr: Int, iterator: Int, increment: Int): Int {
        val pos = curr + (iterator + increment)
        return if ((curr + iterator).row() == pos.row()) pos else -1
    }

    private fun tlCondition(curr: Int, iterator: Int, increment: Int): Int {
        val pos = curr + (iterator - increment)
        return if (pos == cells.size - 1 || (curr + iterator).row() != pos.row()) -1 else pos
    }

    private fun ttlCondition(curr: Int, iterator: Int, increment: Int, moves: Int): Int {
        val pos = (curr - (moves - increment) + iterator - 1)
        return if ((curr + iterator).row() == pos.row()) pos else -1
    }

    private fun ttrCondition(curr: Int, iterator: Int, increment: Int, moves: Int): Int {
        val pos = (curr + (moves - increment) + iterator + 1)
        return if ((curr + iterator).row() == pos.row()) pos else -1
    }

    private fun bllCondition(curr: Int, iterator: Int, increment: Int, moves: Int): Int {
        val pos = (curr - (moves - increment) - iterator - 1)
        return if ((curr - iterator).row() == pos.row()) pos else -1
    }

    private fun blrCondition(curr: Int, iterator: Int, increment: Int, moves: Int): Int {
        val pos = (curr + (moves - increment) - iterator + 1)
        return if ((curr - iterator).row() == pos.row()) pos else -1
    }

    private fun Int.row() = this / colNum

}

