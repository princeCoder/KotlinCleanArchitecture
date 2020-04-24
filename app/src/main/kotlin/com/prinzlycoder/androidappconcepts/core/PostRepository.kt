package com.prinzlycoder.androidappconcepts.core

import com.prinzlycoder.androidappconcepts.core.entities.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
}