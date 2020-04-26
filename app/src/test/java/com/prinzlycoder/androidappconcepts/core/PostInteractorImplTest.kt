package com.prinzlycoder.androidappconcepts.core

import com.prinzlycoder.androidappconcepts.core.entities.Post
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.*
import org.junit.Test

class PostInteractorImplTest {

    private val postRepository: PostRepository = mock()
    private val subject = PostInteractorImpl(postRepository)

    @Test
    fun `Given PostInteractor, When calling getPost, Then PostRepository getPost method is invoked`() {
        runBlocking {
            subject.getPosts()
            Verify on postRepository that postRepository.getPosts() was called
        }
    }

    @Test
    fun `Given PostInteractor, When calling getPost, Then it returns error`() {
        runBlocking {
            val expectedResult = Result.Error(Exception())
            When calling postRepository.getPosts() `it returns` expectedResult
            val actualResult = subject.getPosts()
            expectedResult `should be equal to` actualResult
        }
    }

    @Test
    fun `Given PostInteractor, When calling getPost, Then it returns success`() {
        runBlocking {
            val expectedResult = Result.Success(listOf(Post("title", "body")))
            When calling postRepository.getPosts() `it returns` expectedResult
            val actualResult = subject.getPosts()
            expectedResult `should be equal to`  actualResult
        }
    }
}