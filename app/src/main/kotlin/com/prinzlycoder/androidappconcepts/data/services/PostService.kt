package com.prinzlycoder.androidappconcepts.data.services

import com.prinzlycoder.androidappconcepts.presentation.posts.PostDAO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers

interface PostService {
    @GET("/posts")
    @Headers("Cache-Control: no-cache")
    fun getPostsAsync(): Deferred<List<PostDAO>>
}