interface Error

sealed class Result<out Err, out T>

class Success<T>(val value: T) : Result<Nothing, T>()
class Failure<Error>(val error: Error) : Result<Error, Nothing>()

fun <T, R> Result<Error, T>.map(transform: (T) -> R): Result<Error, R> = when (this) {
    is Success -> Success(transform(value))
    is Failure -> this
}