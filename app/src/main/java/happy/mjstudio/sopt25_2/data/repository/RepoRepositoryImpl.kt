package happy.mjstudio.sopt25_2.data.repository

import android.graphics.Color
import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem
import happy.mjstudio.sopt25_2.domain.entity.Profile
import happy.mjstudio.sopt25_2.domain.repository.RepoRepository

/**
 * Created by mj on 18, October, 2019
 */
class RepoRepositoryImpl : RepoRepository {
    override suspend fun listRepositoryWithProfile(profile: Profile): List<GitRepoItem> {
        return listOf(
            GitRepoItem(
                "My Repository",
                "My repository is a trash project",
                "Java",
                Color.BLUE
            ),
            GitRepoItem(
                "Trash",
                "My repository is a trash project",
                "C",
                Color.GRAY
            ),
            GitRepoItem(
                "Let's Drink",
                "My repository is a trash project",
                "Kotlin",
                Color.YELLOW
            ),
            GitRepoItem(
                "Do it Do it",
                "My repository is a trash project",
                "C#",
                Color.GREEN
            )
        )
    }
}