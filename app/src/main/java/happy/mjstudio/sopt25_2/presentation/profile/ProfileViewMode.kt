package happy.mjstudio.sopt25_2.presentation.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.domain.entity.Profile
import happy.mjstudio.sopt25_2.domain.repository.GithubRepository
import happy.mjstudio.sopt25_2.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by mj on 18, October, 2019
 */

class ProfileViewModel(private val githubRepository: GithubRepository,private val userRepository: UserRepository) : ViewModel() {

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

                val nickname = withContext(Dispatchers.IO){userRepository.nickname}.value!!

                withContext(Dispatchers.IO) {
                    githubRepository.getUser(nickname)
                }
            }.onSuccess {
                _myProfile.value = it
            }.onFailure {
                Log.e(TAG,it.toString())
            }
        }
    }

    private fun listFollowers() {
        viewModelScope.launch {

            kotlin.runCatching {

                val nickname = withContext(Dispatchers.IO){userRepository.nickname}.value!!

                withContext(Dispatchers.IO) {
                    githubRepository.getFollowers(nickname)
                }
            }.onSuccess {
                followers.value = it
            }.onFailure {
                Log.e(TAG,it.toString())
            }
        }
    }

}