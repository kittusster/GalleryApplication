package com.example.galleryapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapplication.R
import com.example.galleryapplication.data.model.Image
import com.example.galleryapplication.databinding.SingleImageItemBinding

class ImageAdapter(
    private var imageList: List<Image>
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    fun setData(imageList: List<Image>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: SingleImageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            SingleImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(imageList[position]) {
                binding.tvName.text = this.title
                Glide
                    .with(binding.imImage.context)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.image_place_holder)
                    .into(binding.imImage)
            }
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return imageList.size
    }
}
