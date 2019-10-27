package happy.mjstudio.sopt25_2.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by mj on 18, October, 2019
 */

@Parcelize
data class Profile (
    val id : String,
    val name : String,
    val avatarUrl : String
) : Parcelable