package com.example.photos.ui.photolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Photo
import com.example.photos.R
import com.example.photos.databinding.ItemPhotoBinding
import java.util.concurrent.Executors


class PhotoListAdapter(private val onItemClick: (Photo) -> Unit) :
    ListAdapter<Photo, PhotoListAdapter.PhotoViewHolder>(
        AsyncDifferConfig.Builder(PhotoDiffUtilItemCallback())
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding) { clickedPos ->
            onItemClick(getItem(clickedPos))
        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.idTextView.text = item.id.toString()
        holder.binding.titleTextView.text = item.title
        Glide.with(holder.itemView.context)
            .load(item.thumbnailUrl + ".png")
            .placeholder(R.drawable.ic_baseline_block_24)
            .circleCrop()
            .into(holder.binding.photoImageView)
    }

    class PhotoViewHolder(val binding: ItemPhotoBinding, onItemClicked: (Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClicked(bindingAdapterPosition)
            }
        }
    }
}