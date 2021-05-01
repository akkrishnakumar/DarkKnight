typealias InputParser = (String) -> Result<Error, Piece>

class DefaultInputParser : InputParser {
    override fun invoke(input: String): Result<Error, Piece> =
        input.split(" ").toPiece()
}

private fun List<String>.toPiece() = when (this[0].toLowerCase()) {
    "king" -> Success(King(this[1]))
    else   -> TODO("Else needs to be implemented")
}

data class ParsingError(val input: String) : Error


