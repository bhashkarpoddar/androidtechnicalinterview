package com.example.androidtechnicalinterview.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.androidtechnicalinterview.R
import com.example.androidtechnicalinterview.databinding.ActivityMainBinding
import com.example.androidtechnicalinterview.domain.model.post.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel by viewModels<MainViewModel>()
    private var postsAdapter: PostAdapter? = null
    private val posts = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initAdapter()
        initObservers()
    }

    private fun initObservers() {
        mainViewModel.uiState.observe(this) {
            when(it){
                is MainUiState.Loading -> {

                }
                is MainUiState.PostSuccess -> {
                    Log.d("TAG", "initObservers: ${it.posts}")
                    posts.addAll(it.posts)
                    postsAdapter?.notifyDataSetChanged()
                }
                is MainUiState.Error -> {

                }
                else -> {
                    Log.d("TAG", "initObservers: $it")
                }
            }
        }
        mainViewModel.getPosts()
    }

    private fun initAdapter() {
        postsAdapter = PostAdapter(posts)
        binding.rvPost.adapter = postsAdapter
    }


    fun trianglePattern() {
        var list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        var row = 5
        var k = 0
        for(i in 1..row){
            for(j in 1..row-i){
                print("  ")
            }
            while (k != 2*i-1){
                print("${list[k]} ")
                ++k
            }
            println()
            k = 0
        }
        /*list.forEachIndexed { index, num ->
            println(list.subList(0, index + 1))
        }*/
    }
}