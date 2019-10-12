package happy.mjstudio.sopt25_2.view.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import happy.mjstudio.sopt25_2.R
import happy.mjstudio.sopt25_2.common.AsteriskPasswordTransformationMethod
import happy.mjstudio.sopt25_2.common.toast
import happy.mjstudio.sopt25_2.data.UserRepository
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.koin.android.ext.android.inject

/**
 * Created by mj on 28, September, 2019
 */

class SignUpActivity : AppCompatActivity() {

    private val userRepository : UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        password.transformationMethod =
            AsteriskPasswordTransformationMethod()
        passwordCheck.transformationMethod =
            AsteriskPasswordTransformationMethod()

        signup.setOnClickListener {

            val f1 = name.text?.toString()
            val f2 = id.text?.toString()
            val f3 = password.text?.toString()
            val f4 = passwordCheck.text?.toString()


            when {
                f1.isNullOrEmpty() -> toast("닉네임을 입력해주세요.")
                f2.isNullOrEmpty() -> toast("아이디를 입력해주세요.")
                f3.isNullOrEmpty() -> toast("비밀번호를 입력해주세요.")
                f4.isNullOrEmpty() -> toast("비밀번호 확인을 입력해주세요.")
                f3 != f4 -> toast("비밀번호가 일치하지 않습니다.")
                else -> {
                    userRepository.signUp(f2,f3)
                    toast("회원 가입 성공!")
                    setResult(100, Intent().apply{putExtra("id",f2);putExtra("password",f3)})
                    finish()
                }
            }
        }
    }
}