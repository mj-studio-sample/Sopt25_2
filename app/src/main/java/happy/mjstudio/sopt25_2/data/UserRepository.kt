package happy.mjstudio.sopt25_2.data

import happy.mjstudio.sopt25_2.common.util.SPUtil

/**
 * Created by mj on 28, September, 2019
 */
class UserRepository(private val spUtil: SPUtil) {

    fun signUp(id: String,password : String) {
        spUtil.putString(SPUtil.SPKeys.ID,id)
        spUtil.putString(SPUtil.SPKeys.PASSWORD,password)
    }

    fun login(id: String, password: String): Boolean {
        val s1 = spUtil.getString(SPUtil.SPKeys.ID)
        val s2 = spUtil.getString(SPUtil.SPKeys.PASSWORD)

        return s1 == id && s2 == password
    }
}