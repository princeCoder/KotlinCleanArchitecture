package com.prinzlycoder.androidappconcepts.presentation.posts

import com.prinzlycoder.androidappconcepts.core.PostContract
import com.prinzlycoder.androidappconcepts.core.PostInteractor
import com.prinzlycoder.androidappconcepts.core.Result
import com.prinzlycoder.androidappconcepts.core.entities.Post
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.*
import org.junit.Before
import org.junit.Test

class PostPresenterTest {

    private val postInteractor: PostInteractor = mock()
    private val view: PostContract.View = mock()
    private lateinit var subject: PostPresenter

    @Before
    fun setUp() {
        subject = PostPresenter(postInteractor)
        subject.attachView(view)
    }

    @Test
    fun `Given PostPresenter, When calling getPostAsync, Then view showProgress and hideProgress methods are invoked`() {
        runBlocking {
            subject.getPostAsync()
            Verify on view that view.showProgress()
            Verify on view that view.hideProgress()
        }
    }

    @Test
    fun `Given PostPresenter, When calling getPostAsync, Then view setPost method is invoked`() {
        runBlocking {
            val posts = listOf(Post("title", "body"), Post("title", "body"))
            When calling postInteractor.getPosts() `it returns` Result.Success(posts)
            subject.getPostAsync()
            Verify on view that view.setPosts(any<List<PostItem>>())
        }
    }

    @Test
    fun `Given PostPresenter, When calling getPostAsync, Then view showMessage method is invoked`() {
        runBlocking {
            When calling postInteractor.getPosts() `it returns` Result.Error(Exception("Something happened"))
            subject.getPostAsync()
            Verify on view that view.showMessage("Something happened")
        }
    }
}