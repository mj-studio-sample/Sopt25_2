package happy.mjstudio.sopt25_2.common

import android.app.Activity
import android.widget.Toast

/**
 * Created by mj on 28, September, 2019
 */

fun Activity.toast(msg : String) = Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()