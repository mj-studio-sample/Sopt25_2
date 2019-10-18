package happy.mjstudio.sopt25_2.presentation.repo

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.databinding.ActivityRepoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRepoBinding

    private val mViewModel: RepoViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRepoBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.vm = mViewModel
        mBinding.lifecycleOwner = this


        initRecyclerView()
    }

    private fun initRecyclerView() {
        mBinding.recyclerView.apply {
            adapter = MainAdapter()
        }
    }

}
