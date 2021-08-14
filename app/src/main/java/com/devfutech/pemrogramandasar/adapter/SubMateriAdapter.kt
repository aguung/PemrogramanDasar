package com.devfutech.pemrogramandasar.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.data.model.SubMateri
import com.devfutech.pemrogramandasar.databinding.ItemSubMateriBinding

class SubMateriAdapter(val onItemClick: (SubMateri) -> Unit) :
    ListAdapter<SubMateri, SubMateriAdapter.SubMateriViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubMateriViewHolder {
        val binding =
            ItemSubMateriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubMateriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubMateriViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class SubMateriViewHolder(private val binding: ItemSubMateriBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mediaPlayer by lazy {
            MediaPlayer.create(binding.root.context, R.raw.button)
        }

        fun bind(item: SubMateri) {
            binding.apply {
                txtMateri.text = item.nama

                root.setOnClickListener {
                    mediaPlayer.start()
                    onItemClick(item)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<SubMateri>() {
        override fun areItemsTheSame(oldItem: SubMateri, newItem: SubMateri) =
            oldItem.nama == newItem.nama

        override fun areContentsTheSame(oldItem: SubMateri, newItem: SubMateri) =
            oldItem == newItem
    }
}