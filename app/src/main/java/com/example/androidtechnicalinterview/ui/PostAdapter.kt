package com.example.androidtechnicalinterview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtechnicalinterview.databinding.PostItemLayoutBinding
import com.example.androidtechnicalinterview.domain.model.post.Post

class PostAdapter(private var posts: MutableList<Post>):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       val postData = posts[position]
        holder.onBind(postData)
    }

    inner class PostViewHolder(val binding: PostItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }

}