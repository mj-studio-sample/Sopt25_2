package happy.mjstudio.sopt25_2.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import happy.mjstudio.sopt25_2.common.Once
import happy.mjstudio.sopt25_2.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by mj on 18, October, 2019
 */

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val TAG = SignUpViewModel::class.java.simpleName

    //region STATUS

    //endregion

    //region DATA
    val name: MutableLiveData<String> = MutableLiveData("")
    val id: MutableLiveData<String> = MutableLiveData("")
    val pw: MutableLiveData<String> = MutableLiveData("")
    val pwCheck: MutableLiveData<String> = MutableLiveData("")


    //endregion

    //region EVENT
    private val _signUpComplete: MutableLiveData<Once<Unit>> = MutableLiveData()
    val signUpComplete: LiveData<Once<Unit>>
        get() = _signUpComplete

    private val _alertMsg: MutableLiveData<Once<String>> = MutableLiveData()
    val alertMsg: LiveData<Once<String>>
        get() = _alertMsg

    //endregion


    fun onClickSignUpButton() {
        if (name.value.isNullOrBlank()) {
            _alertMsg.value = Once("닉네임을 입력해주세요.")
            return
        } else if (id.value.isNullOrBlank()) {
            _alertMsg.value = Once("아이디를 입력해주세요.")
            return
        } else if (pw.value.isNullOrBlank()) {
            _alertMsg.value = Once("비밀번호를 입력해주세요.")
            return
        } else if (pwCheck.value.isNullOrBlank()) {
            _alertMsg.value = Once("비밀번호 확인을 입력해주세요.")
            return
        } else if (pw.value != pwCheck.value) {
            _alertMsg.value = Once("비밀번호 확인이 일치하지 않습니다.")
            return
        }

        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    userRepository.signUp(
                        id.value!!,
                        pw.value!!
                    )
                }
            }.onSuccess {
                _signUpComplete.value = Once(Unit)
            }.onFailure {
                _alertMsg.value = Once("회원가입에 실패했습니다. error : $it")
            }



        }
    }


}