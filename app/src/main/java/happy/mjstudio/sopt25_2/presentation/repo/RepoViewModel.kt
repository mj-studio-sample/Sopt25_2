package happy.mjstudio.sopt25_2.presentation.repo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem
import happy.mjstudio.sopt25_2.domain.entity.Profile
import happy.mjstudio.sopt25_2.domain.repository.RepoRepository
import kotlinx.coroutines.launch

/**
 * Created by mj on 18, October, 2019
 */

class RepoViewModel(val profile : Profile,private val repoRepository: RepoRepository) : ViewModel() {

    private val TAG = RepoViewModel::class.java.simpleName


    //region STATUS

    //endregion

    //region DATA
    val repos: MutableLiveData<List<GitRepoItem>> = MutableLiveData(listOf())
    //endregion

    //region EVENT

    //endregion

    init {
        listRepos()
    }

    private fun listRepos() {
        viewModelScope.launch {
            kotlin.runCatching {
                repoRepository.listRepositoryWithProfile(profile)
            }.onSuccess {
                repos.value = it
            }.onFailure {

            }
        }
    }

}