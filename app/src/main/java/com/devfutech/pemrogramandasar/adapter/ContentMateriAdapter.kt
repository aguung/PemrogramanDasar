package com.devfutech.pemrogramandasar.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.data.model.Content
import com.devfutech.pemrogramandasar.databinding.ItemContentAlurBinding
import com.devfutech.pemrogramandasar.databinding.ItemContentBacaanBinding
import com.devfutech.pemrogramandasar.utils.handleUrlClicks
import com.devfutech.pemrogramandasar.utils.toHtml
import com.github.florent37.expansionpanel.ExpansionLayout
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection


class ContentMateriAdapter(val onItemAlurClick: (Content) -> Unit,val onItemContentClick: (String?) -> Unit, private val contentType: String?) :
    ListAdapter<Content, RecyclerView.ViewHolder>(DiffCallback()) {

    private val expansionsCollection = ExpansionLayoutCollection()

    init {
        expansionsCollection.openOnlyOne(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (contentType) {
            "Alur" -> ContentMateriAlurViewHolder(
                ItemContentAlurBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> ContentMateriBacaanViewHolder(
                ItemContentBacaanBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(getItem(position)) {
            when (holder) {
                is ContentMateriBacaanViewHolder -> {
                    holder.bind(this)
                    expansionsCollection.add(holder.getExpansionLayout())
                }
                is ContentMateriAlurViewHolder -> holder.bind(this)
                else -> null
            }
        }
    }

    inner class ContentMateriBacaanViewHolder(private val binding: ItemContentBacaanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mediaPlayer by lazy {
            MediaPlayer.create(binding.root.context, R.raw.button)
        }
        fun bind(item: Content) {
            binding.apply {
                expansionLayout.collapse(false)
                txtTitle.text = item.nama
                txtContent.apply {
                    text = item.content?.toHtml()
                    handleUrlClicks{
                        mediaPlayer.start()
                        onItemContentClick(it["video"])
                    }
                }
            }
        }

        fun getExpansionLayout(): ExpansionLayout {
            return binding.expansionLayout
        }
    }

    inner class ContentMateriAlurViewHolder(private val binding: ItemContentAlurBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val mediaPlayer by lazy {
            MediaPlayer.create(binding.root.context, R.raw.button)
        }

        fun bind(item: Content) {
            binding.apply {
                txtTitle.text = item.nama
                imageContent.setImageResource(item.image ?: R.drawable.icon)
                if (adapterPosition == currentList.size - 1) imageArrow.isVisible = false
                cardContent.setOnClickListener {
                    mediaPlayer.start()
                    onItemAlurClick(item)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Content>() {
        override fun areItemsTheSame(oldItem: Content, newItem: Content) =
            oldItem.nama == newItem.nama

        override fun areContentsTheSame(oldItem: Content, newItem: Content) =
            oldItem == newItem
    }
}