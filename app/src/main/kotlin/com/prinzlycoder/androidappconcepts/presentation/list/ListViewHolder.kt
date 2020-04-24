package com.prinzlycoder.androidappconcepts.presentation.list

import android.view.ViewGroup
import com.prinzlycoder.androidappconcepts.presentation.inflateLayout

abstract class ListViewHolder<T : ListItem>(parent: ViewGroup, resourceId: Int, internal var adapter: ListAdapter<T>)
    : androidx.recyclerview.widget.RecyclerView.ViewHolder(parent.inflateLayout(resourceId)) {
    abstract fun bindData(data: T)
}
