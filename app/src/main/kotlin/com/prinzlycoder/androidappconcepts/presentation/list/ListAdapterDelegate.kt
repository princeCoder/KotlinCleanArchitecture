package com.prinzlycoder.androidappconcepts.presentation.list


abstract class ListAdapterDelegate<T : ListItem> : AdapterDelegate<T> {
    override fun onBindViewHolder(viewHolder: ListViewHolder<T>, data: T) {
        viewHolder.bindData(data)
    }
}
