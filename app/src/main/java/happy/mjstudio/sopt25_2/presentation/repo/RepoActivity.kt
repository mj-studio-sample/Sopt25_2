package happy.mjstudio.sopt25_2.presentation.repo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.common.widget.LinearItemDecoration
import happy.mjstudio.sopt25_2.databinding.ActivityRepoBinding
import happy.mjstudio.sopt25_2.domain.entity.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf
import kotlin.coroutines.CoroutineContext

class RepoActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    private lateinit var mBinding: ActivityRepoBinding

    private lateinit var mViewModel: RepoViewModel

    companion object {
        private const val ARG_PROFILE = "ARG_PROFILE"
        private const val ARG_IMAGE_TARNSITION_NAME = "ARG_IMAGE_TARNSITION_NAME"

        fun newIntent(activity : Activity,profile : Profile,imageTransitionName : String) : Intent {

            return Intent(activity,RepoActivity::class.java).apply {
                putExtra(ARG_PROFILE,profile as Parcelable)
                putExtra(ARG_IMAGE_TARNSITION_NAME,imageTransitionName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRepoBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        val profile = intent.getParcelableExtra<Profile>(ARG_PROFILE)!!
        val transitionName = intent.getStringExtra(ARG_IMAGE_TARNSITION_NAME)!!
        mBinding.image.transitionName = transitionName
        mViewModel = getViewModel { parametersOf(profile) }

        mBinding.vm = mViewModel
        mBinding.lifecycleOwner = this


        initView()
        observeViewModel()
    }

    private fun initView() {
        mBinding.toolbar.apply {
            this.setNavigationOnClickListener {
                onBackPressed()
            }
        }

        mBinding.recyclerView.apply {
            adapter = RepoAdapter()

            addItemDecoration(LinearItemDecoration(20))
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
