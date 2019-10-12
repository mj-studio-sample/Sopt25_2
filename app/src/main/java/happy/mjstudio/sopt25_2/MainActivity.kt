package happy.mjstudio.sopt25_2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding

    var items : List<GitRepoItem> = listOf(
        GitRepoItem("My Repository","My repository is a trash project","Java", Color.BLUE),
        GitRepoItem("Trash","My repository is a trash project","C", Color.GRAY),
        GitRepoItem("Let's Drink","My repository is a trash project","Kotlin", Color.YELLOW),
        GitRepoItem("Do it Do it","My repository is a trash project","C#", Color.GREEN)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.activity = this

        mBinding.recyclerView.apply {
            adapter = MainAdapter()
        }
    }

}
