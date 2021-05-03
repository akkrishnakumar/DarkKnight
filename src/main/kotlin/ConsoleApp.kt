class ConsoleApp(
    val input: () -> String,
    val output: (String) -> Unit,
    private val board: Board = DefaultBoard(8, 8)
) {
    operator fun invoke(): Unit = board.showMoves(input()).printResult()

    private fun Result<Error, List<String>>.printResult() = when (this) {
        is Success -> output(value.joinToString(", "))
        is Failure -> TODO()
    }
}