interface Board {
    fun showMoves(input: String): List<String>
}

class DefaultBoard(
    rowNum: Int,
    colNum: Int,
    val inputParser: InputParser = DefaultInputParser()
) : Board {

    override fun showMoves(input: String): List<String> {
        inputParser(input)
        return TODO("Need to implement Game logic")
    }

}