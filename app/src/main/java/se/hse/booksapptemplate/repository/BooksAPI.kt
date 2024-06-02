package se.hse.booksapptemplate.repository

import retrofit2.http.GET
import se.hse.booksapptemplate.data.BookItem

interface BooksAPI {

    @GET("get")
    suspend fun getAllBooks(): List<BookItem>
}