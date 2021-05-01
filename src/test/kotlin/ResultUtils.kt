import org.junit.jupiter.api.fail

fun <T> Result<Error, T>.successValue() = when (this) {
    is Success -> value
    is Failure -> fail("Expected a Success but received a Failure")
}

fun <T> Result<Error, T>.failureValue() = when (this) {
    is Failure -> error
    is Success -> fail("Expected a Failure but received a Success")
}