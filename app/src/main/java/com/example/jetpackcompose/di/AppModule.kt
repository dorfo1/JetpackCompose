package com.example.jetpackcompose.di

import com.example.jetpackcompose.core.extension.resolveRetrofit
import com.example.jetpackcompose.core.interceptor.AuthInterceptor
import com.example.jetpackcompose.data.repository.MovieRepository
import com.example.jetpackcompose.data.repository.MovieRepositoryImpl
import com.example.jetpackcompose.data.service.MovieService
import com.example.jetpackcompose.ui.detail.DetailViewModel
import com.example.jetpackcompose.ui.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    val dependencyModules = module {

        single<AuthInterceptor> { AuthInterceptor(get()) }
        single<OkHttpClient> { getOkHttpCliente(get()) }
        single<Retrofit> { getRetrofit(get()) }

        single<MovieService> { resolveRetrofit() }
        single<MovieRepository> { MovieRepositoryImpl(get())}


        viewModel<MainViewModel> { MainViewModel(get()) }
        viewModel<DetailViewModel> { DetailViewModel(get()) }


    }


    private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHttpCliente(
        authenticationInterceptor: AuthInterceptor,
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()

        okHttpClient.addInterceptor(authenticationInterceptor)
        okHttpClient.addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })

        return okHttpClient.build()
    }
}