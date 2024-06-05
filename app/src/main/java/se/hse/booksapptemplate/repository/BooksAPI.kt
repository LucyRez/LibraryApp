package se.hse.booksapptemplate.repository

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.data.BookRequest

interface BooksAPI {

    @GET("get")
    suspend fun getAllBooks(): List<BookItem>

    @GET("get/{id}")
    suspend fun getBookDetails(@Path("id") id: Long): BookItem

    @POST("save")
    suspend fun addNewBook(@Body bookRequest: BookRequest): Long
}