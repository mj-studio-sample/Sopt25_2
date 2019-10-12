package happy.mjstudio.sopt25_2.common

import android.text.method.PasswordTransformationMethod
import android.view.View

/**
 * Created by mj on 28, September, 2019
 */
class AsteriskPasswordTransformationMethod : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence, view: View): CharSequence {
        return PasswordCharSequence(source)
    }


    private inner class PasswordCharSequence(private val mSource: CharSequence)// Store char sequence
        : CharSequence {

        override fun get(index: Int): Char {
            return '*'
        }


        override val length: Int
            get() = mSource.length

        override fun subSequence(start: Int, end: Int): CharSequence {
            return mSource.subSequence(start, end) // Return default
        }
    }
}
