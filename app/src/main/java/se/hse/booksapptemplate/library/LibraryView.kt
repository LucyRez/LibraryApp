package se.hse.booksapptemplate.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.R

@Composable
fun LibraryView(modifier: Modifier, viewModel: LibraryViewModel = hiltViewModel()) {
    val bookList = viewModel.listBooks.value

    LazyColumn (modifier = modifier) {
        items(bookList.size) {
            BookItemView(bookItem = bookList[it])
        }
    }
}


@Composable
fun BookItemView(bookItem: BookItem) {

    Row (verticalAlignment = Alignment.CenterVertically){

        AsyncImage(model = "https://cdn-icons-png.flaticon.com/512/5402/5402751.png", contentDescription = "Book Icon",
            Modifier
                .size(84.dp)
                .padding(8.dp))

//        Image(painterResource(id = R.drawable.book_icon),
//            "Book Icon",
//            Modifier
//                .size(84.dp)
//                .padding(8.dp))

        Column {
            Text(text = bookItem.title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = bookItem.author, fontSize = 14.sp)
        }
    }

}
