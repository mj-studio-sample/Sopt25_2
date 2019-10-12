package happy.mjstudio.sopt25_2.common

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Created by mj on 12, October, 2019
 */

@BindingAdapter("android:visibility")
fun View.setVisibilityBinding(visible : Boolean) {
    this.visibility = if(visible) View.VISIBLE else View.GONE
}