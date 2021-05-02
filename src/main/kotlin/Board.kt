interface Board {
    fun showMoves(input: String): Result<Error, List<String>>
}

class DefaultBoard(
    rowNum: Int,
    colNum: Int,
    val gameLogic: GameLogic = DefaultGameLogic(rowNum, colNum),
    val inputParser: InputParser = DefaultInputParser()
) : Board {
    override fun showMoves(input: String): Result<Error, List<String>> =
        inputParser(input).map(gameLogic)
}