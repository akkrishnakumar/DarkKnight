import org.junit.jupiter.api.fail

fun <T> Result<Error, T>.successValue() = when (this) {
    is Success -> value
    is Failure -> fail("Expected a Success but received a Failure: $this")
}