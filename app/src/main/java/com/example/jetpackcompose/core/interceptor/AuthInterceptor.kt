package com.example.jetpackcompose.core.interceptor

import android.content.Context
import com.example.jetpackcompose.R
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context) : Interceptor {

    companion object {
        private const val API_KEY_QUERY : String = "&api_key="
    }

    private val appKey : String by lazy { context.resources.getString(R.string.app_key) }


    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .url("${request.url}$API_KEY_QUERY$appKey")
            .build()


        return chain.proceed(request)
    }
}