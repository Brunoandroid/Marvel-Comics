package com.example.marvelcomics.data.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url().newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", "628947d6bdef9adde5d37857037809fc")
            .addQueryParameter("hash", "39d2656927a63715d037e9f8003dbd00")
            .build()

        val resquest = chain.request().newBuilder()
            .url(url)
            .build()

        return chain.proceed(resquest)
    }
}