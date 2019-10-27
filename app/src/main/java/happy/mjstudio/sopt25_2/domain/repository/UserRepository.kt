package happy.mjstudio.sopt25_2.domain.repository

import androidx.lifecycle.MutableLiveData

/**
 * Created by mj on 28, September, 2019
 */
interface UserRepository {

    val nickname : MutableLiveData<String>

    suspend fun signUp(id: String,password : String)

    suspend fun login(id: String, password: String): Boolean
}