interface Board {
    fun showMoves(input: String): List<String>
}

class DefaultBoard(rowNum: Int, colNum: Int) : Board {

    override fun showMoves(input: String): List<String> = TODO("Need to implement input parser")

}