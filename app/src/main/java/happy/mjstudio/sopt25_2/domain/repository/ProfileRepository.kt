package happy.mjstudio.sopt25_2.domain.repository

import happy.mjstudio.sopt25_2.domain.entity.Profile

/**
 * Created by mj on 18, October, 2019
 */

interface ProfileRepository {
    suspend fun getMyProfile() : Profile
    suspend fun listFollowers() : List<Profile>
}