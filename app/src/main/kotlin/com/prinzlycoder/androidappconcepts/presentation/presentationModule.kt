package com.prinzlycoder.androidappconcepts.presentation

import com.prinzlycoder.androidappconcepts.core.PostContract
import com.prinzlycoder.androidappconcepts.presentation.posts.PostPresenter
import org.koin.dsl.module

val presentationModule = module {
    factory {
        val postPresenter: PostContract.Presenter =
            PostPresenter(get())
        postPresenter
    }
}