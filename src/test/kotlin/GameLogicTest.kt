import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class GameLogicTest {

    val gameLogic = DefaultGameLogic(8, 8)

    @Test
    internal fun `should return possible moves for a given piece`() {
        val expected = listOf("E5", "E6", "D6", "C6", "C5", "C4", "D4", "E4")
        val input = King("D5")

        val actual = gameLogic(input)

        assertThat(actual, equalTo(expected))
    }


}