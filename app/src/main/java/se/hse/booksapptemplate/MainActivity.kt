package se.hse.booksapptemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import se.hse.booksapptemplate.book.BookDetailScreen
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
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = "library_screen") {
                        composable("library_screen") {
                            LibraryView(Modifier.padding(vertical = innerPadding.calculateTopPadding()), navController = navController)
                        }

                        composable("book_detail_screen/{id}", arguments = listOf(
                            navArgument("id") {
                                type = NavType.LongType
                                nullable = false
                            }
                        )) {
                            val id = remember {
                                it.arguments?.getLong("id")
                            }
                            BookDetailScreen(modifier = Modifier.padding(innerPadding.calculateTopPadding()), id!!, viewModel = hiltViewModel(), navController)
                        }

                    }
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