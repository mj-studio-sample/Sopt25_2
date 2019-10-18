package happy.mjstudio.sopt25_2.data.repository

import happy.mjstudio.sopt25_2.domain.entity.Follower
import happy.mjstudio.sopt25_2.domain.repository.ProfileRepository

/**
 * Created by mj on 18, October, 2019
 */

class ProfileRepositoryImpl : ProfileRepository {

    override suspend fun listFollowers(): List<Follower> {
        return listOf(
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio"),
            Follower("mym0404","MJ Studio")
        )
    }
}