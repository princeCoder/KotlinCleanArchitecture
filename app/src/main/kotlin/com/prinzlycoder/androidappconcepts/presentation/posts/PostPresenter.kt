package com.prinzlycoder.androidappconcepts.presentation.posts

import com.prinzlycoder.androidappconcepts.core.PostContract
import com.prinzlycoder.androidappconcepts.core.PostInteractor
import com.prinzlycoder.androidappconcepts.core.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PostPresenter(private val postInteractor: PostInteractor) : PostContract.Presenter,
    CoroutineScope {

    private var view: PostContract.View? = null

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var job: Job? = null

    override fun attachView(view: PostContract.View) {
        this.view = view
    }

    override fun getPosts() {
        job = launch {
            getPostAsync()
        }
    }

    private suspend fun getPostAsync() {
        view?.showProgress()
        when (val result = postInteractor.getPosts()) {
            is Result.Success -> view?.setPosts(result.data.map { it.mapToPostItem() })
            is Result.Error -> result.throwable.message?.let { view?.showMessage(it) }
        }
        view?.hideProgress()
    }
}