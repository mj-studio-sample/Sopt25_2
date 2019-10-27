package happy.mjstudio.sopt25_2.data.api

import happy.mjstudio.sopt25_2.data.dto.FollowerDTO
import happy.mjstudio.sopt25_2.data.dto.GetUserDTO
import happy.mjstudio.sopt25_2.data.dto.RepoDTO
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by mj on 26, October, 2019
 */
interface GithubAPI {
    @GET("users/{username}/followers")
    suspend fun listFollowers(@Path("username") username : String) : List<FollowerDTO>

    @GET("users/{login}")
    suspend fun getUser(@Path("login") login : String) : GetUserDTO

    @GET("users/{login}/repos")
    suspend fun listRepos(@Path("login") login : String) : List<RepoDTO>
}


