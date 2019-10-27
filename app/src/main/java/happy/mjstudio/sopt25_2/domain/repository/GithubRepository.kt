package happy.mjstudio.sopt25_2.domain.repository

import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem
import happy.mjstudio.sopt25_2.domain.entity.Profile

/**
 * Created by mj on 18, October, 2019
 */
interface GithubRepository {
    suspend fun listRepos(username : String) : List<GitRepoItem>

    suspend fun getUser(username : String) : Profile

    suspend fun getFollowers(username : String ) : List<Profile>
}