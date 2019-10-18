package happy.mjstudio.sopt25_2.presentation.repo

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem

/**
 * Created by mj on 18, October, 2019
 */

class RepoViewModel : ViewModel() {

    private val TAG = RepoViewModel::class.java.simpleName


    //region STATUS

    //endregion

    //region DATA
    val repos: MutableLiveData<List<GitRepoItem>> = MutableLiveData(
        listOf(
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
    )
    //endregion

    //region EVENT

    //endregion

    init {

    }

}