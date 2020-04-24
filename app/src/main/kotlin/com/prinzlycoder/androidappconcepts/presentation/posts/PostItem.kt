package com.prinzlycoder.androidappconcepts.presentation.posts

import com.prinzlycoder.androidappconcepts.core.entities.Post
import com.prinzlycoder.androidappconcepts.core.PostContract
import com.prinzlycoder.androidappconcepts.presentation.list.ListItem

class PostItem(val title: String, val body: String) : PostContract.Model, ListItem

fun Post.mapToPostItem(): PostItem{
    return PostItem(title, body)
}