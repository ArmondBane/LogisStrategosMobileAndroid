package com.goodcomp.strategems.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.goodcomp.core.domain.entity.Stratagem
import com.goodcomp.strategems.R
import com.goodcomp.strategems.databinding.ItemStratagemFromListBinding

class StratagemsListAdapter(
    private val onItemClick: (item: Stratagem) -> Unit,
) : ListAdapter<Stratagem, StratagemsListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemStratagemFromListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemStratagemFromListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Stratagem) {
            binding.cvRoot.setOnClickListener { onItemClick(item) }
            binding.ivIcon.setImageResource(item.picture)
            binding.tvTitle.text = item.name
            binding.tvCost.text = item.cost
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Stratagem>() {
        override fun areItemsTheSame(
            oldItem: Stratagem,
            newItem: Stratagem
        ) = oldItem.name == newItem.name
        override fun areContentsTheSame(
            oldItem: Stratagem,
            newItem: Stratagem
        ) = oldItem == newItem
    }
}