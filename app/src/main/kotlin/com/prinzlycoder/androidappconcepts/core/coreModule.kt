package com.prinzlycoder.androidappconcepts.core

import org.koin.dsl.module

val coreModule = module {
    factory {
        val postInteractor: PostInteractor =
            PostInteractorImpl(get())
        postInteractor
    }
}