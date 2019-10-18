package happy.mjstudio.sopt25_2.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.domain.entity.Profile
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
    private val _myProfile : MutableLiveData<Profile> = MutableLiveData()
    val myProfile : LiveData<Profile>
        get() = _myProfile
    
    val followers : MutableLiveData<List<Profile>> = MutableLiveData(listOf())

    //endregion

    //region EVENT

    //endregion

    init {
        getMyProfile()
        listFollowers()
    }

    private fun getMyProfile() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    profileRepository.getMyProfile()
                }
            }.onSuccess {
                _myProfile.value = it
            }.onFailure {

            }
        }
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