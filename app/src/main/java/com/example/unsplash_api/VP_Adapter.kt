package com.example.unsplash_api

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplash_api.databinding.VpItmeBinding
import com.example.unsplash_api.model.PhotoData

class VP_Adapter(val context: Context, val PhotoList: MutableList<PhotoData>) :
    RecyclerView.Adapter<VP_Adapter.ViewHolder>() {

    private lateinit var binding: VpItmeBinding

    class ViewHolder(val binding: VpItmeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = VpItmeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(PhotoList[position].url.regular)
            .placeholder(ColorDrawable(Color.parseColor(PhotoList[position].color)))
            .into(holder.binding.img1)
    }

    override fun getItemCount(): Int {
        return PhotoList.size
    }


}