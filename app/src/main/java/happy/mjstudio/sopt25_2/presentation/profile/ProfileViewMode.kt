package happy.mjstudio.sopt25_2.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.domain.entity.Follower
import happy.mjstudio.sopt25_2.domain.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by mj on 18, October, 2019
 */

class ProfileViewModel(private val profileRepository: ProfileRepository) : ViewModel() {

    private val TAG = ProfileViewModel::class.java.simpleName


    //region STATUS

    //endregion

    //region DATA
    val followers : MutableLiveData<List<Follower>> = MutableLiveData(listOf())

    //endregion

    //region EVENT

    //endregion

    init {
        listFollowers()
    }

    private fun listFollowers() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    profileRepository.listFollowers()
                }
            }.onSuccess {
                followers.value = it
            }.onFailure {

            }
        }
    }

}