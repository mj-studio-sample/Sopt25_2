package happy.mjstudio.sopt25_2.domain.repository

import happy.mjstudio.sopt25_2.domain.entity.Follower

/**
 * Created by mj on 18, October, 2019
 */

interface ProfileRepository {
    suspend fun listFollowers() : List<Follower>
}