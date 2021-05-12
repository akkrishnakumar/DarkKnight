import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.util.*

class ConsoleTest {

    private val console = Stack<String>()

    @Test
    internal fun `should print possible positions of given piece on console`() {
        val expected = "E5, E6, D6, C6, C5, C4, D4, E4"
        val input = "King D5"
        val consoleApp = ConsoleApp({ input }, { console.push(it) })

        consoleApp()
        val actual = console.pop()

        assertThat(actual, equalTo(expected))
    }

    @Test
    internal fun `should print error message when invalid input was entered on the console`() {
        val expected = "Invalid Input: Duke A0"
        val input = "Duke A0"
        val consoleApp = ConsoleApp({ input }, { console.push(it) })

        consoleApp()
        val actual = console.pop()

        assertThat(actual, equalTo(expected))
    }

    @Test
    internal fun `should print 'No possible moves' when no possible moves are found for a piece`() {
        val expected = "No possible moves"
        val input = "Queen A0"
        val consoleApp = ConsoleApp({ input }, { console.push(it) })

        consoleApp()
        val actual = console.pop()

        assertThat(actual, equalTo(expected))
    }
}