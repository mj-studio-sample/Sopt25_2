package happy.mjstudio.sopt25_2.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.sopt25_2.databinding.ItemFollowerBinding
import happy.mjstudio.sopt25_2.domain.entity.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

/**
 * Created by mj on 18, October, 2019
 */
@ExperimentalCoroutinesApi
class FollowerAdapter(private val scope : CoroutineScope) : RecyclerView.Adapter<FollowerAdapter.FollowerHolder>() {

    val clickEvent : BroadcastChannel<Profile> = BroadcastChannel(Channel.CONFLATED)

    private val diff = object : DiffUtil.ItemCallback<Profile>() {
        override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer<Profile>(this,diff)

    fun submitItems(items : List<Profile>) {
        differ.submitList(items)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFollowerBinding.inflate(inflater, parent, false)

        return FollowerHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: FollowerHolder, position: Int) = holder.bind(differ.currentList[position])


    inner class FollowerHolder(val binding: ItemFollowerBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                scope.launch {
                    val item = differ.currentList[layoutPosition]
                    clickEvent.send(item)
                }
            }
        }

        fun bind(item: Any) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}

@BindingAdapter("app:recyclerview_follower_items")
fun RecyclerView.setItems(items: List<Profile>) {
    (adapter as? FollowerAdapter)?.run {
        this.submitItems(items)
    }
}