import com.natpryce.hamkrest.MatchResult
import com.natpryce.hamkrest.MatchResult.Match
import com.natpryce.hamkrest.MatchResult.Mismatch
import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.describe

fun containsAllOf(expected: List<String>) =
    object : Matcher<List<String>> {

        override fun invoke(actual: List<String>): MatchResult =
            if (expected.containsAll(actual)) Match
            else Mismatch("was ${describe(actual)}")

        override val description: String get() = "is equal to ${describe(expected)}"

    }
