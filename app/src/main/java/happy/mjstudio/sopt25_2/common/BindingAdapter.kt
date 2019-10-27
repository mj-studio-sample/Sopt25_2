package happy.mjstudio.sopt25_2.common

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by mj on 12, October, 2019
 */

@BindingAdapter("android:visibility")
fun View.setVisibilityBinding(visible : Boolean) {
    this.visibility = if(visible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageSrc")
fun ImageView.setImageBinding(src : String?) {
    src ?: return
    Glide.with(this).load(src).into(this)
}
@BindingAdapter("imageSrc")
fun ImageView.setImageBinding(@DrawableRes src : Int?) {
    src ?: return
    Glide.with(this).load(src).into(this)
}
@BindingAdapter("imageSrc")
fun ImageView.setImageBinding(src : Uri?) {
    src ?: return
    Glide.with(this).load(src).into(this)
}