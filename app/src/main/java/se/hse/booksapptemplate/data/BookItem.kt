package se.hse.booksapptemplate.data


data class BookItem(
    val id: Long? = null,
    val title: String,
    val author: String,
    val description: String? = null,
    val rating: Double? = null
)
