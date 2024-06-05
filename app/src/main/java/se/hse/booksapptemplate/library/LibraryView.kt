package se.hse.booksapptemplate.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.R


@Composable
fun LibraryView(modifier: Modifier, viewModel: LibraryViewModel = hiltViewModel(), navController: NavController) {
    val bookList = viewModel.listBooks.value
    var newBookTitle by remember {
        mutableStateOf("")
    }

    Column (modifier = modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            TextField(value = newBookTitle,
                onValueChange = { newBookTitle = it},
                label = { Text("New Book Title")},
                modifier = Modifier.padding(horizontal = 8.dp))
            Button(onClick = { viewModel.addNewBook(newBookTitle) }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }

        LazyColumn () {
            items(bookList.size) {
                BookItemView(bookItem = bookList[it], navController)
            }
        }
    }

}


@Composable
fun BookItemView(bookItem: BookItem, navController: NavController) {

    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("book_detail_screen/${bookItem.id}")
            }){

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
