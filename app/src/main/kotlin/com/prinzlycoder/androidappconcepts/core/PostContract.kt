package com.prinzlycoder.androidappconcepts.core

interface PostContract {

    interface View {
        fun setPosts(posts: List<Model>)
        fun showMessage(message: String)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter{
        fun attachView(view: View)
        fun getPosts()
    }

    interface Model
}