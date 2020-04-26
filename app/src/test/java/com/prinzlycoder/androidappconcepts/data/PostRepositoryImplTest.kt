package com.prinzlycoder.androidappconcepts.data

import com.prinzlycoder.androidappconcepts.core.Result.Success
import com.prinzlycoder.androidappconcepts.core.entities.Post
import com.prinzlycoder.androidappconcepts.data.services.PostService
import com.prinzlycoder.androidappconcepts.data.services.ServiceProvider
import com.prinzlycoder.androidappconcepts.presentation.posts.PostDAO
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.*
import org.junit.Test

class PostRepositoryImplTest {

    private val serviceProvider: ServiceProvider = mock()
    private val subject = PostRepositoryImpl(serviceProvider)

    @Test
    fun `Given PostRepository, when calling getPost method, Then it returns list of post when successful`() {
        runBlocking {
            val postService: PostService = mock()
            val postResponse = CompletableDeferred(listOf(PostDAO(1, "title", "body", 1234)))
            val expected = Success(listOf(Post("title", "body")))
            When calling serviceProvider.getPostService() `it returns` postService
            When calling postService.getPostsAsync() `it returns` postResponse
            val actual = subject.getPosts()
            Verify on postService that postService.getPostsAsync() was called
            expected `should be equal to` actual
        }
    }

    @Test(expected = Exception::class)
    fun `Given PostRepository, when calling getPost method, Then it returns an error`() {
        runBlocking {
            val postService: PostService = mock()
            When calling postService.getPostsAsync() `it throws` Exception("Something happened")
            When calling serviceProvider.getPostService() `it returns` postService
            subject.getPosts()
        }
    }
}