class ConsoleApp(
    val input: () -> String = ::readInput,
    val output: (String) -> Unit = ::printOutput,
    private val board: Board = DefaultBoard(8, 8)
) {
    operator fun invoke(): Unit = board.showMoves(input()).printResult()

    private fun Result<Error, List<String>>.printResult() = when (this) {
        is Success -> output(value.joinToString(", "))
        is Failure -> output("Invalid Input: ${error.getErrorMessage()}")
    }

    private fun Error.getErrorMessage() = when (this) {
        is ParsingError -> input
        else            -> ""
    }
}

private fun readInput(): String {
    println(":::Welcome To DarkknighT:::")
    println("Enter your piece along with the position:")
    return readLine()!!
}

private fun printOutput(value: String) {
    println(value)
    println(":::::Thank You:::::")
}