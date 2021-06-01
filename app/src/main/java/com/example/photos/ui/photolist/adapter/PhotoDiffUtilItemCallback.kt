package com.example.photos.ui.photolist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Photo

class PhotoDiffUtilItemCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

}
