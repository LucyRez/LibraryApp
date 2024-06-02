package se.hse.booksapptemplate.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): Resource<T>(data)
    class Failure<T>(msg: String): Resource<T>(message = msg)
}