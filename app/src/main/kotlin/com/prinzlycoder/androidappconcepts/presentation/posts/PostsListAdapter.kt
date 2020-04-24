package com.prinzlycoder.androidappconcepts.presentation.posts

import com.prinzlycoder.androidappconcepts.presentation.list.ListAdapter
import com.prinzlycoder.androidappconcepts.presentation.list.ListAdapterDelegate
import com.prinzlycoder.androidappconcepts.presentation.list.ListItem

class PostsListAdapter : ListAdapter<ListItem>() {
    init {
        delegateManager.addDelegates(PostDelegate() as ListAdapterDelegate<ListItem>)
    }
}