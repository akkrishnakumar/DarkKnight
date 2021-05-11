typealias InputParser = (String) -> Result<Error, Piece>

class DefaultInputParser : InputParser {
    override fun invoke(input: String): Result<Error, Piece> =
        input.split(" ").toPiece()
}

private fun List<String>.toPiece() = when (this[0].toLowerCase()) {
    "king"   -> Success(King(this[1]))
    "knight" -> Success(Knight(this[1]))
    "queen"  -> Success(Queen(this[1]))
    "bishop" -> Success(Bishop(this[1]))
    "rook"   -> Success(Rook(this[1]))
    else     -> Failure(ParsingError(this.joinToString(" ")))
}

data class ParsingError(val input: String) : Error


