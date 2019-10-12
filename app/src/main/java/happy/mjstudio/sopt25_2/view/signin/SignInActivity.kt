package happy.mjstudio.sopt25_2.view.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.R
import happy.mjstudio.sopt25_2.common.AsteriskPasswordTransformationMethod
import happy.mjstudio.sopt25_2.common.toast
import happy.mjstudio.sopt25_2.data.UserRepository
import happy.mjstudio.sopt25_2.view.main.MainActivity
import happy.mjstudio.sopt25_2.view.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.koin.android.ext.android.inject

class SignInActivity : AppCompatActivity() {

    private val userRepository : UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        password.transformationMethod =
            AsteriskPasswordTransformationMethod()

        signup.setOnClickListener {
            Intent(this@SignInActivity, SignUpActivity::class.java).apply {
                startActivityForResult(
                    this,
                    100
                )
            }
        }
        signin.setOnClickListener {
            val f1 = id.text.toString()
            val f2 = password.text.toString()

            when {
                f1.isNullOrEmpty() -> toast("아이디를 입력해주세요.")
                f2.isNullOrEmpty() -> toast("비밀번호를 입력해주세요.")
                !userRepository.login(f1,f2) -> toast("로그인에 실패했습니다.")
                else -> {
                    navigateMainActivity()
                }
            }
        }
    }

    private fun navigateMainActivity() {
        Intent(this,MainActivity::class.java).apply {
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
