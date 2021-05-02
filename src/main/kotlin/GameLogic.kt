typealias GameLogic = (Piece) -> List<String>

class DefaultGameLogic : GameLogic {
    override fun invoke(piece: Piece): List<String> = TODO("Need to implement game logic")
}