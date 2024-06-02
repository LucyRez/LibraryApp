package se.hse.booksapptemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import se.hse.booksapptemplate.library.LibraryView
import se.hse.booksapptemplate.library.LibraryViewModel
import se.hse.booksapptemplate.repository.BookRepository
import se.hse.booksapptemplate.ui.theme.BooksAppTemplateTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooksAppTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   LibraryView(Modifier.padding(vertical = innerPadding.calculateTopPadding()))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BooksAppTemplateTheme {
        Greeting("Android")
    }
}