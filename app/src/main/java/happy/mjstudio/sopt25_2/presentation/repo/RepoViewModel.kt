package happy.mjstudio.sopt25_2.presentation.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem
import happy.mjstudio.sopt25_2.domain.entity.Profile
import happy.mjstudio.sopt25_2.domain.repository.GithubRepository
import kotlinx.coroutines.launch

/**
 * Created by mj on 18, October, 2019
 */

class RepoViewModel(val profile : Profile,private val repoRepository: GithubRepository) : ViewModel() {

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
                repoRepository.listRepos(profile.name)
            }.onSuccess {
                repos.value = it
            }.onFailure {
                Log.e(TAG,it.toString())
            }
        }
    }

}