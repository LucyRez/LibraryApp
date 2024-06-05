package se.hse.booksapptemplate.book


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import se.hse.booksapptemplate.data.BookItem
import se.hse.booksapptemplate.util.Resource

@Composable
fun BookDetailScreen(modifier: Modifier, id: Long, viewModel: BookViewModel, navController: NavController) {

    val book = produceState<Resource<BookItem>>(initialValue = Resource.Success(BookItem(0, "", "", ""))){
         value = viewModel.getBookDetails(id)
    }.value
    

    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        NavBarDetail(navController = navController)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = "https://cdn-icons-png.flaticon.com/512/5402/5402751.png", contentDescription = "Book Icon",
                modifier = Modifier
                    .size(180.dp)
                    .padding(16.dp))
            Text(text = book.data!!.title,
                fontSize = 24.sp, fontWeight = FontWeight.Medium)
            Text(text = book.data.author,
                fontSize = 16.sp, color = Color.DarkGray, modifier = Modifier.padding(vertical = 4.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Rating", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Text(text = "⭐️⭐⭐⭐⭐", fontSize = 16.sp, modifier = Modifier.padding(horizontal = 4.dp))
            }

            Column (modifier = Modifier.padding(vertical = 8.dp)) {
                Text(text = "Description", fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Text(text = book.data!!.description!!)
            }


        }

    }
}

@Composable
fun NavBarDetail(navController: NavController) {
    Box(
        contentAlignment = Alignment.TopStart,
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Blue,
            modifier = Modifier
                .size(36.dp)
                .offset(y = 16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
        
        Spacer(modifier = Modifier.fillMaxWidth())
    }
}