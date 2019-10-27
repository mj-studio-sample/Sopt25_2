package happy.mjstudio.sopt25_2.data.repository

import androidx.lifecycle.MutableLiveData
import happy.mjstudio.sopt25_2.common.util.SPUtil
import happy.mjstudio.sopt25_2.domain.repository.UserRepository

/**
 * Created by mj on 18, October, 2019
 */

class UserRepositoryImpl(private val spUtil: SPUtil)  : UserRepository{

    override val nickname  : MutableLiveData<String> = MutableLiveData()

    override suspend fun signUp(id: String,password : String) {
        spUtil.putString(SPUtil.SPKeys.ID,id)
        spUtil.putString(SPUtil.SPKeys.PASSWORD,password)
    }

    override suspend fun login(id: String, password: String): Boolean {
        val s1 = spUtil.getString(SPUtil.SPKeys.ID)
        val s2 = spUtil.getString(SPUtil.SPKeys.PASSWORD)

        return (s1 == id && s2 == password).also {
            if(it)
                nickname.postValue(s1!!)
        }
    }
}