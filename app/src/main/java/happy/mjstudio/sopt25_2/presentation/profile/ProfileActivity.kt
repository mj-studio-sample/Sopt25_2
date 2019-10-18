package happy.mjstudio.sopt25_2.presentation.profile

import android.app.ActivityOptions
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.common.widget.LinearItemDecoration
import happy.mjstudio.sopt25_2.databinding.ActivityProfileBinding
import happy.mjstudio.sopt25_2.domain.entity.Profile
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
        mBinding.toolbar.apply {
            this.setNavigationOnClickListener {

            }
        }

        mBinding.recyclerView.apply {
            adapter = FollowerAdapter(this@ProfileActivity).apply {

                launch {
                    for (event in clickEvent.openSubscription()) {
                        navigateRepoActivity(event)
                    }
                }
            }
            addItemDecoration(LinearItemDecoration(20))
        }
    }
    private fun navigateRepoActivity(profile : Profile) {
        kotlin.runCatching {
            val idx = mViewModel.followers.value?.indexOfFirst { it.id === profile.id }!!
            val view = (mBinding.recyclerView.findViewHolderForLayoutPosition(idx) as FollowerAdapter.FollowerHolder).binding.image
            val transitionName = "image$idx"
            val pair = Pair<View, String>(view, transitionName)

            val bundle = ActivityOptions.makeSceneTransitionAnimation(this, pair).toBundle()


            RepoActivity.newIntent(this, profile, transitionName)
                .apply { startActivity(this, bundle) }
        }.onFailure {
            RepoActivity.newIntent(this, profile, "image1")
                .apply { startActivity(this) }
        }


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