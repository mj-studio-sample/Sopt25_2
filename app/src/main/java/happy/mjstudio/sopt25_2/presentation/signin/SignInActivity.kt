package happy.mjstudio.sopt25_2.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.common.AsteriskPasswordTransformationMethod
import happy.mjstudio.sopt25_2.common.observeOnce
import happy.mjstudio.sopt25_2.common.toast
import happy.mjstudio.sopt25_2.databinding.ActivitySignInBinding
import happy.mjstudio.sopt25_2.presentation.profile.ProfileActivity
import happy.mjstudio.sopt25_2.presentation.repo.RepoActivity
import happy.mjstudio.sopt25_2.presentation.signup.SignUpActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity : AppCompatActivity() {

    private val TAG = SignInActivity::class.java.simpleName

    private lateinit var mBinding : ActivitySignInBinding

    private val mViewModel : SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySignInBinding.inflate(LayoutInflater.from(this))
        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel
        setContentView(mBinding.root)

        initView()
        observeViewModel()

    }

    private fun initView() {
        mBinding.password.transformationMethod = AsteriskPasswordTransformationMethod()
    }

    private fun observeViewModel() {
        mViewModel.apply {
            navigateSignUp.observeOnce(this@SignInActivity) {
                Intent(this@SignInActivity, SignUpActivity::class.java).apply {
                    startActivityForResult(
                        this,
                        100
                    )
                }
            }

            navigateProfile.observeOnce(this@SignInActivity) {
                Intent(this@SignInActivity,ProfileActivity::class.java).apply { startActivity(this) }
            }

            alertMsg.observeOnce(this@SignInActivity) {
                toast(it)
            }
        }
    }

    private fun navigateMainActivity() {
        Intent(this,RepoActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            val id = data?.getStringExtra("id")
            val password = data?.getStringExtra("password")

            toast("id : $id, password : $password")
        }


    }
}
