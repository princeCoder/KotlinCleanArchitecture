package com.prinzlycoder.androidappconcepts.data

import com.prinzlycoder.androidappconcepts.core.PostRepository
import com.prinzlycoder.androidappconcepts.core.Result
import com.prinzlycoder.androidappconcepts.core.entities.Post
import com.prinzlycoder.androidappconcepts.data.services.ServiceProvider
import com.prinzlycoder.androidappconcepts.presentation.posts.mapToPost

class PostRepositoryImpl(private val serviceProvider: ServiceProvider) : PostRepository {

    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val postService = serviceProvider.getPostService()
            val postDAOs = postService.getPostsAsync().await()
            val posts = postDAOs.map { it.mapToPost() }
            Result.Success(posts)
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }
}