package happy.mjstudio.sopt25_2.data.repository

import happy.mjstudio.sopt25_2.data.api.GithubAPI
import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem
import happy.mjstudio.sopt25_2.domain.entity.Profile
import happy.mjstudio.sopt25_2.domain.repository.GithubRepository

/**
 * Created by mj on 18, October, 2019
 */
class GithubRepositoryImpl(private val api : GithubAPI) : GithubRepository {
    override suspend fun listRepos(username: String): List<GitRepoItem> {
        val repoDtos = api.listRepos(username)
        return repoDtos.map {
            GitRepoItem(it.fullName,it.description ?: "",null,null)
        }
    }

    override suspend fun getUser(username: String): Profile {
        val userDTO = api.getUser(username)
        return Profile(userDTO.id.toString(),userDTO.login)
    }

    override suspend fun getFollowers(username: String): List<Profile> {
        val userDTOList = api.listFollowers(username)
        return userDTOList.map { Profile(it.id.toString(),it.login) }
    }
}