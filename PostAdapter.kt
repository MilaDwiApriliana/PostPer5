package com.mila141.posttestpemrogrammobile5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mila141.posttestpemrogrammobile5.databinding.ItemPostBinding
import com.mila141.posttestpemrogrammobile5.model.Post

class PostAdapter(
    private val posts: MutableList<Post>,
    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.binding.tvUsername.text = post.username
        holder.binding.tvCaption.text = post.caption

        // Menampilkan gambar dari URI (galeri) atau default drawable
        if (post.imageUri != null) {
            holder.binding.imgPost.setImageURI(post.imageUri)
        } else if (post.imageResId != null) {
            holder.binding.imgPost.setImageResource(post.imageResId)
        }

        holder.binding.btnDelete.setOnClickListener {
            onDelete(position)
        }
    }

    override fun getItemCount() = posts.size
}
