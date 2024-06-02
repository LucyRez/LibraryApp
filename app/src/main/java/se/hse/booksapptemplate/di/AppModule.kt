package se.hse.booksapptemplate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import se.hse.booksapptemplate.repository.BookRepository
import se.hse.booksapptemplate.repository.BooksAPI
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(api: BooksAPI): BookRepository = BookRepository(booksAPI = api)

    @Provides
    @Singleton
    fun provideAPI(): BooksAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/api/books/")
            .build().create(BooksAPI::class.java)
    }

}