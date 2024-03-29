package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.data.MarsPhoto
import com.example.android.marsphotos.databinding.GridViewItemBinding

class PhotoGridAdapter :
    ListAdapter<MarsPhoto, MarsPhotoViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean = oldItem.imgSrcUrl == newItem.imgSrcUrl

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        return MarsPhotoViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}

class MarsPhotoViewHolder(
    private var binding: GridViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(MarsPhoto: MarsPhoto) {
        binding.photo = MarsPhoto
        binding.executePendingBindings()
    }
}