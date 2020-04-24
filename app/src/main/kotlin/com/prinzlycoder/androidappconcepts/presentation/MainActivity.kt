package com.prinzlycoder.androidappconcepts.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prinzlycoder.androidappconcepts.R
import com.prinzlycoder.androidappconcepts.core.PostContract
import com.prinzlycoder.androidappconcepts.presentation.list.ListItem
import com.prinzlycoder.androidappconcepts.presentation.posts.PostsListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), PostContract.View {

    private val postPresenter: PostContract.Presenter by inject()
    private lateinit var postAdapter: PostsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postPresenter.attachView(this)
        val postsLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        postAdapter = PostsListAdapter()
        post_list.apply {
            layoutManager = postsLayoutManager
            adapter = postAdapter
        }
        postPresenter.getPosts()
    }

    override fun setPosts(posts: List<PostContract.Model>) {
        postAdapter.setItems(posts as List<ListItem>)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.hide()
    }
}
