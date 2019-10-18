package happy.mjstudio.sopt25_2.presentation.repo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.sopt25_2.BR
import happy.mjstudio.sopt25_2.databinding.ItemRepoBinding
import happy.mjstudio.sopt25_2.domain.entity.GitRepoItem

/**
 * Created by mj on 12, October, 2019
 */
class RepoAdapter : RecyclerView.Adapter<RepoAdapter.MainHolder>() {


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
        val binding = ItemRepoBinding.inflate(inflater, parent, false)

        return MainHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) = holder.bind(differ.currentList[position])


    inner class MainHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}

@BindingAdapter("app:recyclerview_repo_items")
fun RecyclerView.setItems(items: List<GitRepoItem>) {
    (adapter as? RepoAdapter)?.run {
        this.submitItems(items)
    }
}