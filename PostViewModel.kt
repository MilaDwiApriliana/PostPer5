package com.mila141.posttestpemrogrammobile5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mila141.posttestpemrogrammobile5.model.Post

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<MutableList<Post>>(mutableListOf())
    val posts: LiveData<MutableList<Post>> = _posts

    fun addPost(post: Post) {
        _posts.value?.add(0, post)
        _posts.value = _posts.value
    }

    fun deletePost(index: Int) {
        _posts.value?.removeAt(index)
        _posts.value = _posts.value
    }
}
