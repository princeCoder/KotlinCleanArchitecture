package com.prinzlycoder.androidappconcepts.presentation.list

import android.view.ViewGroup
import java.util.*


open class DelegateManager<T : ListItem>(private var adapter: ListAdapter<T>) {
    private val delegates = ArrayList<ListAdapterDelegate<T>>()

    fun addDelegates(delegate: ListAdapterDelegate<T>): DelegateManager<T> {
        delegates.add(delegate)
        return this
    }

    fun addDelegates(position: Int, delegate: ListAdapterDelegate<T>): DelegateManager<T> {
        delegates.add(position, delegate)
        return this
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder<T> {
        return delegates[viewType].onCreateViewHolder(parent, adapter)
    }

    fun onBindViewHolder(viewHolder: ListViewHolder<T>, data: T) {
        val viewType = viewHolder.itemViewType
        delegates[viewType].onBindViewHolder(viewHolder, data)
    }

    fun getViewType(data: ListItem): Int {
        delegates
                .filter { it.isDelegateForDataType(data) }
                .forEach { return delegates.indexOf(it) }
        throw IllegalArgumentException("No AdapterDelegate found for data: " + data)
    }
}