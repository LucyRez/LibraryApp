package se.hse.booksapptemplate.repository

import android.util.Log
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.util.Resource
import javax.inject.Inject

class BookRepository @Inject constructor (private val booksAPI: BooksAPI) {

    suspend fun getAllBooks(): Resource<List<BookItem>> {
        val result = try {
            Resource.Success(booksAPI.getAllBooks())
        } catch (e: Exception) {
            Log.w("Test", "Unknown error")
            Resource.Failure("Bad data")
        }
        return result
    }

}