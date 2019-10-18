package happy.mjstudio.sopt25_2.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.common.Once
import happy.mjstudio.sopt25_2.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by mj on 18, October, 2019
 */

class SignInViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val TAG = SignInViewModel::class.java.simpleName

    //region STATUS

    //endregion

    //region DATA
    val id: MutableLiveData<String> = MutableLiveData("")
    val pw: MutableLiveData<String> = MutableLiveData("")
    //endregion

    //region EVENT
    private val _navigateSignUp: MutableLiveData<Once<Unit>> = MutableLiveData()
    val navigateSignUp: LiveData<Once<Unit>>
        get() = _navigateSignUp

    private val _navigateProfile: MutableLiveData<Once<Unit>> = MutableLiveData()
    val navigateProfile: LiveData<Once<Unit>>
        get() = _navigateProfile

    private val _alertMsg: MutableLiveData<Once<String>> = MutableLiveData()
    val alertMsg: LiveData<Once<String>>
        get() = _alertMsg

    //endregion


    private fun signIn() {
        viewModelScope.launch {
            val result = kotlin.runCatching {
                withContext(Dispatchers.IO + SupervisorJob()) {
                    userRepository.login(
                        id.value!!,
                        pw.value!!
                    )
                }
            }

            if (result.isSuccess) {
                _navigateProfile.value = Once(Unit)
            } else {
                _alertMsg.value = Once("로그인에 실패했습니다. error : ${result.exceptionOrNull()}")
            }
        }
    }


    fun onClickSignInButton() {
        signIn()
    }

    fun onClickSignUpButton() {
        _navigateSignUp.value = Once(Unit)
    }
}