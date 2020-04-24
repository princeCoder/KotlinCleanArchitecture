package com.prinzlycoder.androidappconcepts.presentation.posts

import android.view.ViewGroup
import com.prinzlycoder.androidappconcepts.R
import com.prinzlycoder.androidappconcepts.presentation.list.ListAdapter
import com.prinzlycoder.androidappconcepts.presentation.list.ListAdapterDelegate
import com.prinzlycoder.androidappconcepts.presentation.list.ListItem
import com.prinzlycoder.androidappconcepts.presentation.list.ListViewHolder

class PostDelegate :
    ListAdapterDelegate<PostItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        adapter: ListAdapter<PostItem>
    ): ListViewHolder<PostItem> {
        return PostViewHolder(
            parent,
            R.layout.post_row_item,
            adapter
        )
    }

    override fun isDelegateForDataType(data: ListItem): Boolean {
        return data is PostItem
    }
}