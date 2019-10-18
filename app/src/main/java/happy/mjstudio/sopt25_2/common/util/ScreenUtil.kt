package happy.mjstudio.sopt25_2.common.util

import android.app.Application
import kotlin.math.roundToInt

/**
 * Created by mj on 18, October, 2019
 */
class ScreenUtil(private val context: Application) {

    val screenWidth: Int
        get() = context.resources.displayMetrics.widthPixels

    val screenHeight: Int
        get() = context.resources.displayMetrics.heightPixels

    fun toPixel(dp : Int) = (dp * context.resources.displayMetrics.density).roundToInt()
    fun toDP(pixel : Int) = (pixel / context.resources.displayMetrics.density).roundToInt()
}