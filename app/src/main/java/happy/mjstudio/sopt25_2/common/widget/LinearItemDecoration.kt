package happy.mjstudio.sopt25_2.common.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.sopt25_2.common.util.ScreenUtil
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by mj on 18, October, 2019
 */
class LinearItemDecoration(spacingDP: Int) : RecyclerView.ItemDecoration(), KoinComponent {

    private val screenUtil: ScreenUtil by inject()
    private val spacingPixel = screenUtil.toPixel(spacingDP)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val pos = parent.getChildLayoutPosition(view)

        outRect.bottom = spacingPixel
        if (pos == 0)
            outRect.top = spacingPixel

    }


}