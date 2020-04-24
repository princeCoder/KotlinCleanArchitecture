package com.prinzlycoder.androidappconcepts.presentation.posts

import android.view.View
import android.view.ViewGroup
import com.prinzlycoder.androidappconcepts.presentation.list.ListAdapter
import com.prinzlycoder.androidappconcepts.presentation.list.ListViewHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.post_row_item.view.*

class PostViewHolder(
    parent: ViewGroup,
    resId: Int,
    adapter: ListAdapter<PostItem>
) : ListViewHolder<PostItem>(parent, resId, adapter), LayoutContainer {
    override val containerView: View?
        get() = itemView

    override fun bindData(data: PostItem) {
        itemView.title.text = data.title
        itemView.body.text = data.body
    }
}