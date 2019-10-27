package happy.mjstudio.sopt25_2.data.dto

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by mj on 26, October, 2019
 */
@Parcelize
data class FollowerDTO(
    @SerializedName("login")
    @Expose(serialize = true, deserialize = true)
    var login: String,
    @SerializedName("id")
    @Expose(serialize = true, deserialize = true)
    var id: Int,
    @SerializedName("node_id")
    @Expose(serialize = true, deserialize = true)
    var nodeId: String,
    @SerializedName("avatar_url")
    @Expose(serialize = true, deserialize = true)
    var avatarUrl: String,
    @SerializedName("gravatar_id")
    @Expose(serialize = true, deserialize = true)
    var gravatarId: String,
    @SerializedName("url")
    @Expose(serialize = true, deserialize = true)
    var url: String,
    @SerializedName("html_url")
    @Expose(serialize = true, deserialize = true)
    var htmlUrl: String,
    @SerializedName("followers_url")
    @Expose(serialize = true, deserialize = true)
    var followersUrl: String,
    @SerializedName("following_url")
    @Expose(serialize = true, deserialize = true)
    var followingUrl: String,
    @SerializedName("gists_url")
    @Expose(serialize = true, deserialize = true)
    var gistsUrl: String,
    @SerializedName("starred_url")
    @Expose(serialize = true, deserialize = true)
    var starredUrl: String,
    @SerializedName("subscriptions_url")
    @Expose(serialize = true, deserialize = true)
    var subscriptionsUrl: String,
    @SerializedName("organizations_url")
    @Expose(serialize = true, deserialize = true)
    var organizationsUrl: String,
    @SerializedName("repos_url")
    @Expose(serialize = true, deserialize = true)
    var reposUrl: String,
    @SerializedName("events_url")
    @Expose(serialize = true, deserialize = true)
    var eventsUrl: String,
    @SerializedName("received_events_url")
    @Expose(serialize = true, deserialize = true)
    var receivedEventsUrl: String,
    @SerializedName("type")
    @Expose(serialize = true, deserialize = true)
    var type: String,
    @SerializedName("site_admin")
    @Expose(serialize = true, deserialize = true)
    var siteAdmin: Boolean
) : Parcelable
