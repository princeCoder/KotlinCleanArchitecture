package com.prinzlycoder.androidappconcepts.presentation.posts


import com.prinzlycoder.androidappconcepts.core.entities.Post
import com.squareup.moshi.Json

data class PostDAO(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "body")
    val body: String = "",
    @Json(name = "userId")
    val userId: Int = 0
)


fun PostDAO.mapToPost(): Post {
    return Post(title, body)
}