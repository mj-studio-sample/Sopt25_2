package happy.mjstudio.sopt25_2.presentation.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.sopt25_2.databinding.ItemFollowerBinding
import happy.mjstudio.sopt25_2.domain.entity.Follower
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

    val clickEvent : BroadcastChannel<Follower> = BroadcastChannel(Channel.CONFLATED)

    private val diff = object : DiffUtil.ItemCallback<Follower>() {
        override fun areItemsTheSame(oldItem: Follower, newItem: Follower): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Follower, newItem: Follower): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer<Follower>(this,diff)

    fun submitItems(items : List<Follower>) {
        differ.submitList(items)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFollowerBinding.inflate(inflater, parent, false)

        return FollowerHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: FollowerHolder, position: Int) = holder.bind(differ.currentList[position])


    inner class FollowerHolder(private val binding: ItemFollowerBinding) : RecyclerView.ViewHolder(binding.root) {
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
fun RecyclerView.setItems(items: List<Follower>) {
    (adapter as? FollowerAdapter)?.run {
        this.submitItems(items)
    }
}