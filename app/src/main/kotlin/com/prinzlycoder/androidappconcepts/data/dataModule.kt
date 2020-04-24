package com.prinzlycoder.androidappconcepts.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.prinzlycoder.androidappconcepts.core.PostRepository
import com.prinzlycoder.androidappconcepts.data.environments.Environment
import com.prinzlycoder.androidappconcepts.data.network.NetworkServiceFactory
import com.prinzlycoder.androidappconcepts.data.network.ServiceFactory
import com.prinzlycoder.androidappconcepts.data.services.ServiceProvider
import com.prinzlycoder.androidappconcepts.data.services.ServiceProviderImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {
    factory {
        val moshi =
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        moshi
    }

    single {
        val converterFactory: Converter.Factory = MoshiConverterFactory.create(get())
        converterFactory
    }

    single {
        val callAdapterFactory: CallAdapter.Factory = CoroutineCallAdapterFactory()
        callAdapterFactory
    }

    factory { HttpLoggingInterceptor.Level.BODY }

    factory { Environment("https://jsonplaceholder.typicode.com/") }

    single {
        val serviceFactory: ServiceFactory = NetworkServiceFactory(
            get(),
            get(),
            get(),
            get()
        )
        serviceFactory
    }

    factory {
        val serviceProvider: ServiceProvider = ServiceProviderImpl(get())
        serviceProvider
    }

    factory {
        val postRepository: PostRepository =
            PostRepositoryImpl(get())
        postRepository
    }
}