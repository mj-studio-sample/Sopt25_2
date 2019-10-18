package happy.mjstudio.sopt25_2.data.repository

import happy.mjstudio.sopt25_2.domain.entity.Profile
import happy.mjstudio.sopt25_2.domain.repository.ProfileRepository

/**
 * Created by mj on 18, October, 2019
 */

class ProfileRepositoryImpl : ProfileRepository {

    override suspend fun getMyProfile(): Profile {
        return  Profile("mym0404","MJ Studio")
    }

    override suspend fun listFollowers(): List<Profile> {
        return listOf(
            Profile("mym04041","MJ Studio"),
            Profile("mym04042","MJ Studio"),
            Profile("mym04043","MJ Studio"),
            Profile("mym04044","MJ Studio"),
            Profile("mym04045","MJ Studio"),
            Profile("mym04046","MJ Studio"),
            Profile("mym04047","MJ Studio"),
            Profile("mym04048","MJ Studio")
        )
    }
}