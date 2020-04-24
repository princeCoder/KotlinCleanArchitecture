package com.prinzlycoder.androidappconcepts.core

import com.prinzlycoder.androidappconcepts.core.entities.Post

interface PostInteractor {
    suspend fun getPosts(): Result<List<Post>>
}