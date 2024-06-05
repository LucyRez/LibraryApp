package se.hse.booksapptemplate.book

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.repository.BookRepository
import se.hse.booksapptemplate.util.Resource
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(val bookRepository: BookRepository): ViewModel() {

    suspend fun getBookDetails(id: Long): Resource<BookItem> {
       return bookRepository.getBookDetails(id)
    }
}