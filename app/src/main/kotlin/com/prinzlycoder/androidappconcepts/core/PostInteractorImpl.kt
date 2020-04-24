package com.prinzlycoder.androidappconcepts.core

import com.prinzlycoder.androidappconcepts.core.entities.Post

class PostInteractorImpl(private val postRepository: PostRepository) : PostInteractor {
    override suspend fun getPosts(): Result<List<Post>> {
        return postRepository.getPosts()
    }
}