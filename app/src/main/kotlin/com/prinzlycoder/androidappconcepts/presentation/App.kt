package com.prinzlycoder.androidappconcepts.presentation

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prinzlycoder.androidappconcepts.core.coreModule
import com.prinzlycoder.androidappconcepts.data.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(presentationModule, coreModule, dataModule)
        }
    }
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun ViewGroup.inflateLayout(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
