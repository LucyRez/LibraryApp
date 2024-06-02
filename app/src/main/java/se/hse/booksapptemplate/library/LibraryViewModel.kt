package se.hse.booksapptemplate.library

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.repository.BookRepository
import se.hse.booksapptemplate.util.Resource
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(val bookRepository: BookRepository): ViewModel() {

    var listBooks = mutableStateOf<List<BookItem>>(listOf())

    init {
        getAllBooks()
    }

    fun getAllBooks() {
        viewModelScope.launch {
            when(val books = bookRepository.getAllBooks()) {
                is Resource.Failure -> Log.w("Test", "Failure during request")
                is Resource.Success -> {
                    listBooks.value = books.data ?: listOf()
                    listBooks.value += books.data ?: listOf()
                    listBooks.value += books.data ?: listOf()
                }
            }

        }
    }

}