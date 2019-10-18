package happy.mjstudio.sopt25_2.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.common.AsteriskPasswordTransformationMethod
import happy.mjstudio.sopt25_2.common.observeOnce
import happy.mjstudio.sopt25_2.common.toast
import happy.mjstudio.sopt25_2.databinding.ActivitySignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by mj on 28, September, 2019
 */

class SignUpActivity : AppCompatActivity() {

    private val TAG = SignUpActivity::class.java.simpleName

    private lateinit var mBinding : ActivitySignUpBinding

    private val mViewModel : SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignUpBinding.inflate(LayoutInflater.from(this))
        mBinding.lifecycleOwner = this
        mBinding.vm = mViewModel
        setContentView(mBinding.root)

        initView()
        observeViewModel()

    }

    private fun initView() {
        mBinding.password.transformationMethod = AsteriskPasswordTransformationMethod()
        mBinding.passwordCheck.transformationMethod = AsteriskPasswordTransformationMethod()
    }

    private fun observeViewModel() {
        mViewModel.apply {

            signUpComplete.observeOnce(this@SignUpActivity) {
                setResult(100, Intent().apply{putExtra("id",mViewModel.id.value!!);putExtra("password",mViewModel.pw.value!!)})
                finish()
            }

            alertMsg.observeOnce(this@SignUpActivity) {
                toast(it)
            }
        }
    }
}