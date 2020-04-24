package com.prinzlycoder.androidappconcepts.data.network

import com.prinzlycoder.androidappconcepts.data.environments.Environment
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter

class NetworkServiceFactory(
    converterFactory: Converter.Factory,
    callAdapterFactory: CallAdapter.Factory,
    logLevel: HttpLoggingInterceptor.Level,
    environment: Environment
) : ServiceFactory(converterFactory, callAdapterFactory, logLevel, environment) {

    override fun interceptors(): List<Interceptor> {
        return arrayListOf(NetworkRequestInterceptor(listOf()))
    }
}