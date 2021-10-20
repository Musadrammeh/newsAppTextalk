package com.example.newsapptt.di

import com.example.newsapptt.remote.NewsAPI
import com.example.newsapptt.repository.NewsRepository
import com.example.newsapptt.endpoint.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        api: NewsAPI
    ) = NewsRepository(api)

    @Singleton
    @Provides
    fun provideNewsApi(): NewsAPI{
        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor(createLogger())
            .build()


        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder)
            .baseUrl(BASE_URL)
            .build()
            .create(NewsAPI::class.java)
    }

    /**
     * Create a network logger that prints body and header
     * @return interceptor that logs headers and body
     */
    private fun createLogger(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }
}