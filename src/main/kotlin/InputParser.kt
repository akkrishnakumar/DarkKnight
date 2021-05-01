typealias InputParser = (String) -> Result<Error, Piece>

class DefaultInputParser : InputParser {
    override fun invoke(input: String): Result<Error, Piece> = TODO("Need to implement parser")
}

