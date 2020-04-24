package com.prinzlycoder.androidappconcepts.data.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class NetworkRequestInterceptor(private val networkHeaders: List<NetworkRequestHeader>) : Interceptor {

    @Throws(IOException::class)
    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        networkHeaders.forEach {
            requestBuilder.addHeader(it.type, it.value)
        }
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
