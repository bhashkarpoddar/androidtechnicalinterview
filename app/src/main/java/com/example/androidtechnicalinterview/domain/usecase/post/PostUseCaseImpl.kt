package com.example.androidtechnicalinterview.domain.usecase.post

import com.example.androidtechnicalinterview.data.dto.posts.PostDTO
import com.example.androidtechnicalinterview.data.dto.posts.PostsDTO
import com.example.androidtechnicalinterview.data.dto.users.UserDTO
import com.example.androidtechnicalinterview.data.dto.users.UsersDTO
import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.example.androidtechnicalinterview.domain.model.post.Post
import com.example.androidtechnicalinterview.domain.repository.PostsRepository
import com.example.androidtechnicalinterview.domain.repository.UsersRepository
import javax.inject.Inject

class PostUseCaseImpl @Inject constructor(private val usersRepository: UsersRepository, private val postsRepository: PostsRepository):
    PostUseCase {

    override suspend fun invoke(): NetworkResult<MutableList<Post>> {
        return when(val users = usersRepository.getUsers()) {
            is NetworkResult.Failure -> {
                NetworkResult.Failure(null, users.message ?: "Something went wrong!!!")
            }

            is NetworkResult.Success -> {
                when(val posts = postsRepository.getPosts()) {
                    is NetworkResult.Failure -> {
                        NetworkResult.Failure(null, posts.message ?: "Something went wrong!!!")
                    }
                    is NetworkResult.Success -> {
                        NetworkResult.Success(
                            data = mapToPostDomain(posts.data!!, users.data!!),
                            message = posts.message ?: ""
                        )
                    }
                }
            }
        }
    }

    fun mapToDomain(postDTO: PostDTO, userDTO: UserDTO): Post = Post(
        id = postDTO.id.toString().orEmpty(),
        title = postDTO.title.orEmpty(),
        body = postDTO.body.orEmpty(),
        lat =  userDTO.address.geo.lat.orEmpty(),
        lng = userDTO.address.geo.lng.orEmpty(),
        companyName = userDTO.company.name.orEmpty()
    )

    fun mapToPostDomain(postsDTO: PostsDTO, usersDTO: UsersDTO): MutableList<Post> {
        val posts = mutableListOf<Post>()
        postsDTO.forEachIndexed { index, post ->
            val user = usersDTO.find { it.id == post.id }
            if (user != null) {
                posts.add(mapToDomain(post, user))
            }
        }
        return posts
    }

}