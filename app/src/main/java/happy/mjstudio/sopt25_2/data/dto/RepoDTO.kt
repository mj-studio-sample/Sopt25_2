package happy.mjstudio.sopt25_2.data.dto
import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


/**
 * Created by mj on 26, October, 2019
 */
@Parcelize
data class RepoDTO(
    @SerializedName("id")
    @Expose(serialize = true, deserialize = true)
    var id: Int,
    @SerializedName("node_id")
    @Expose(serialize = true, deserialize = true)
    var nodeId: String,
    @SerializedName("name")
    @Expose(serialize = true, deserialize = true)
    var name: String,
    @SerializedName("full_name")
    @Expose(serialize = true, deserialize = true)
    var fullName: String,
    @SerializedName("owner")
    @Expose(serialize = true, deserialize = true)
    var owner: Owner,
    @SerializedName("private")
    @Expose(serialize = true, deserialize = true)
    var `private`: Boolean,
    @SerializedName("html_url")
    @Expose(serialize = true, deserialize = true)
    var htmlUrl: String,
    @SerializedName("description")
    @Expose(serialize = true, deserialize = true)
    var description: String? = "",
    @SerializedName("fork")
    @Expose(serialize = true, deserialize = true)
    var fork: Boolean,
    @SerializedName("url")
    @Expose(serialize = true, deserialize = true)
    var url: String,
    @SerializedName("archive_url")
    @Expose(serialize = true, deserialize = true)
    var archiveUrl: String,
    @SerializedName("assignees_url")
    @Expose(serialize = true, deserialize = true)
    var assigneesUrl: String,
    @SerializedName("blobs_url")
    @Expose(serialize = true, deserialize = true)
    var blobsUrl: String,
    @SerializedName("branches_url")
    @Expose(serialize = true, deserialize = true)
    var branchesUrl: String,
    @SerializedName("collaborators_url")
    @Expose(serialize = true, deserialize = true)
    var collaboratorsUrl: String,
    @SerializedName("comments_url")
    @Expose(serialize = true, deserialize = true)
    var commentsUrl: String,
    @SerializedName("commits_url")
    @Expose(serialize = true, deserialize = true)
    var commitsUrl: String,
    @SerializedName("compare_url")
    @Expose(serialize = true, deserialize = true)
    var compareUrl: String,
    @SerializedName("contents_url")
    @Expose(serialize = true, deserialize = true)
    var contentsUrl: String,
    @SerializedName("contributors_url")
    @Expose(serialize = true, deserialize = true)
    var contributorsUrl: String,
    @SerializedName("deployments_url")
    @Expose(serialize = true, deserialize = true)
    var deploymentsUrl: String,
    @SerializedName("downloads_url")
    @Expose(serialize = true, deserialize = true)
    var downloadsUrl: String,
    @SerializedName("events_url")
    @Expose(serialize = true, deserialize = true)
    var eventsUrl: String,
    @SerializedName("forks_url")
    @Expose(serialize = true, deserialize = true)
    var forksUrl: String,
    @SerializedName("git_commits_url")
    @Expose(serialize = true, deserialize = true)
    var gitCommitsUrl: String,
    @SerializedName("git_refs_url")
    @Expose(serialize = true, deserialize = true)
    var gitRefsUrl: String,
    @SerializedName("git_tags_url")
    @Expose(serialize = true, deserialize = true)
    var gitTagsUrl: String,
    @SerializedName("git_url")
    @Expose(serialize = true, deserialize = true)
    var gitUrl: String,
    @SerializedName("issue_comment_url")
    @Expose(serialize = true, deserialize = true)
    var issueCommentUrl: String,
    @SerializedName("issue_events_url")
    @Expose(serialize = true, deserialize = true)
    var issueEventsUrl: String,
    @SerializedName("issues_url")
    @Expose(serialize = true, deserialize = true)
    var issuesUrl: String,
    @SerializedName("keys_url")
    @Expose(serialize = true, deserialize = true)
    var keysUrl: String,
    @SerializedName("labels_url")
    @Expose(serialize = true, deserialize = true)
    var labelsUrl: String,
    @SerializedName("languages_url")
    @Expose(serialize = true, deserialize = true)
    var languagesUrl: String,
    @SerializedName("merges_url")
    @Expose(serialize = true, deserialize = true)
    var mergesUrl: String,
    @SerializedName("milestones_url")
    @Expose(serialize = true, deserialize = true)
    var milestonesUrl: String,
    @SerializedName("notifications_url")
    @Expose(serialize = true, deserialize = true)
    var notificationsUrl: String,
    @SerializedName("pulls_url")
    @Expose(serialize = true, deserialize = true)
    var pullsUrl: String,
    @SerializedName("releases_url")
    @Expose(serialize = true, deserialize = true)
    var releasesUrl: String,
    @SerializedName("ssh_url")
    @Expose(serialize = true, deserialize = true)
    var sshUrl: String,
    @SerializedName("stargazers_url")
    @Expose(serialize = true, deserialize = true)
    var stargazersUrl: String,
    @SerializedName("statuses_url")
    @Expose(serialize = true, deserialize = true)
    var statusesUrl: String,
    @SerializedName("subscribers_url")
    @Expose(serialize = true, deserialize = true)
    var subscribersUrl: String,
    @SerializedName("subscription_url")
    @Expose(serialize = true, deserialize = true)
    var subscriptionUrl: String,
    @SerializedName("tags_url")
    @Expose(serialize = true, deserialize = true)
    var tagsUrl: String,
    @SerializedName("teams_url")
    @Expose(serialize = true, deserialize = true)
    var teamsUrl: String,
    @SerializedName("trees_url")
    @Expose(serialize = true, deserialize = true)
    var treesUrl: String,
    @SerializedName("clone_url")
    @Expose(serialize = true, deserialize = true)
    var cloneUrl: String,
    @SerializedName("mirror_url")
    @Expose(serialize = true, deserialize = true)
    var mirrorUrl: String,
    @SerializedName("hooks_url")
    @Expose(serialize = true, deserialize = true)
    var hooksUrl: String,
    @SerializedName("svn_url")
    @Expose(serialize = true, deserialize = true)
    var svnUrl: String,
    @SerializedName("homepage")
    @Expose(serialize = true, deserialize = true)
    var homepage: String,
    @SerializedName("language")
    @Expose(serialize = true, deserialize = true)
    var language: @RawValue Any?,
    @SerializedName("forks_count")
    @Expose(serialize = true, deserialize = true)
    var forksCount: Int,
    @SerializedName("stargazers_count")
    @Expose(serialize = true, deserialize = true)
    var stargazersCount: Int,
    @SerializedName("watchers_count")
    @Expose(serialize = true, deserialize = true)
    var watchersCount: Int,
    @SerializedName("size")
    @Expose(serialize = true, deserialize = true)
    var size: Int,
    @SerializedName("default_branch")
    @Expose(serialize = true, deserialize = true)
    var defaultBranch: String,
    @SerializedName("open_issues_count")
    @Expose(serialize = true, deserialize = true)
    var openIssuesCount: Int,
    @SerializedName("is_template")
    @Expose(serialize = true, deserialize = true)
    var isTemplate: Boolean,
    @SerializedName("topics")
    @Expose(serialize = true, deserialize = true)
    var topics: List<String>,
    @SerializedName("has_issues")
    @Expose(serialize = true, deserialize = true)
    var hasIssues: Boolean,
    @SerializedName("has_projects")
    @Expose(serialize = true, deserialize = true)
    var hasProjects: Boolean,
    @SerializedName("has_wiki")
    @Expose(serialize = true, deserialize = true)
    var hasWiki: Boolean,
    @SerializedName("has_pages")
    @Expose(serialize = true, deserialize = true)
    var hasPages: Boolean,
    @SerializedName("has_downloads")
    @Expose(serialize = true, deserialize = true)
    var hasDownloads: Boolean,
    @SerializedName("archived")
    @Expose(serialize = true, deserialize = true)
    var archived: Boolean,
    @SerializedName("disabled")
    @Expose(serialize = true, deserialize = true)
    var disabled: Boolean,
    @SerializedName("pushed_at")
    @Expose(serialize = true, deserialize = true)
    var pushedAt: String,
    @SerializedName("created_at")
    @Expose(serialize = true, deserialize = true)
    var createdAt: String,
    @SerializedName("updated_at")
    @Expose(serialize = true, deserialize = true)
    var updatedAt: String,
    @SerializedName("permissions")
    @Expose(serialize = true, deserialize = true)
    var permissions: Permissions,
    @SerializedName("template_repository")
    @Expose(serialize = true, deserialize = true)
    var templateRepository: @RawValue Any?,
    @SerializedName("subscribers_count")
    @Expose(serialize = true, deserialize = true)
    var subscribersCount: Int,
    @SerializedName("network_count")
    @Expose(serialize = true, deserialize = true)
    var networkCount: Int,
    @SerializedName("license")
    @Expose(serialize = true, deserialize = true)
    var license: License
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Owner(
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

    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Permissions(
        @SerializedName("admin")
        @Expose(serialize = true, deserialize = true)
        var admin: Boolean,
        @SerializedName("push")
        @Expose(serialize = true, deserialize = true)
        var push: Boolean,
        @SerializedName("pull")
        @Expose(serialize = true, deserialize = true)
        var pull: Boolean
    ) : Parcelable

    @SuppressLint("ParcelCreator")
    @Parcelize
    data class License(
        @SerializedName("key")
        @Expose(serialize = true, deserialize = true)
        var key: String,
        @SerializedName("name")
        @Expose(serialize = true, deserialize = true)
        var name: String,
        @SerializedName("spdx_id")
        @Expose(serialize = true, deserialize = true)
        var spdxId: String,
        @SerializedName("url")
        @Expose(serialize = true, deserialize = true)
        var url: String,
        @SerializedName("node_id")
        @Expose(serialize = true, deserialize = true)
        var nodeId: String
    ) : Parcelable
}