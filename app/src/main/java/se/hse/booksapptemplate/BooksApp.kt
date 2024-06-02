package se.hse.booksapptemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BooksApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}