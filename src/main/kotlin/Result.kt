interface Error

sealed class Result<out Err, out T>

class Success<T>(val value: T) : Result<Nothing, T>()
class Failure<Error>(val error: Error) : Result<Error, Nothing>()
