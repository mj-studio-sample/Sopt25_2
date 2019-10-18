package happy.mjstudio.sopt25_2.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.databinding.ActivityProfileBinding
import happy.mjstudio.sopt25_2.domain.entity.Follower
import happy.mjstudio.sopt25_2.presentation.repo.RepoActivity
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext

/**
 * Created by mj on 18, October, 2019
 */
@ExperimentalCoroutinesApi
class ProfileActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    private lateinit var mBinding : ActivityProfileBinding

    private val mViewModel : ProfileViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityProfileBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel

        initView()
        observeViewModel()
    }

    private fun initView() {
        mBinding.recyclerView.apply {
            adapter = FollowerAdapter(this@ProfileActivity).apply {

                launch {
                    for (event in clickEvent.openSubscription()) {
                        navigateRepoActivity(event)
                    }
                }
            }
        }
    }
    private fun navigateRepoActivity(follower : Follower) {
        Intent(this,RepoActivity::class.java).apply { startActivity(this) }
    }

    private fun observeViewModel() {
        mViewModel.apply {
            
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        coroutineContext.cancel()
    }
}