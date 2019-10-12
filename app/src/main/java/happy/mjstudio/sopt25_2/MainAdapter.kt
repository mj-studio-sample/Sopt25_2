package happy.mjstudio.sopt25_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.sopt25_2.databinding.ItemMainBinding

/**
 * Created by mj on 12, October, 2019
 */

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {


    private val diff = object : DiffUtil.ItemCallback<GitRepoItem>() {
        override fun areItemsTheSame(oldItem: GitRepoItem, newItem: GitRepoItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GitRepoItem, newItem: GitRepoItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer<GitRepoItem>(this,diff)

    fun submitItems(items : List<GitRepoItem>) {
        differ.submitList(items)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(inflater, parent, false)

        return MainHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) = holder.bind(differ.currentList[position])


    inner class MainHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}

@BindingAdapter("app:recyclerview_main_repo_items")
fun RecyclerView.setItems(items: List<GitRepoItem>) {
    (adapter as? MainAdapter)?.run {
        this.submitItems(items)
    }
}