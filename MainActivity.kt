package com.mila141.posttestpemrogrammobile5

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mila141.posttestpemrogrammobile5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe data postingan
        postViewModel.posts.observe(this) { posts ->
            adapter = PostAdapter(posts) { index ->
                postViewModel.deletePost(index)
            }
            binding.rvPosts.layoutManager = LinearLayoutManager(this)
            binding.rvPosts.adapter = adapter
        }

        // Tombol tambah postingan
        binding.btnAddPost.setOnClickListener {
            AddPostDialog { post ->
                postViewModel.addPost(post)
            }.show(supportFragmentManager, "AddPostDialog")
        }
    }
}
