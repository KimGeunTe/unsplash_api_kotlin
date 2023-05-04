package com.example.unsplash_api

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplash_api.databinding.ItmeBinding
import com.example.unsplash_api.model.PhotoData
import java.util.ArrayList

class RV_Adapter (var context: Context, var PhotoList:MutableList<PhotoData>):RecyclerView.Adapter<RV_Adapter.ViewHolder>(){

    private lateinit var binding: ItmeBinding
    class ViewHolder(val binding: ItmeBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItmeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    // 이미지 불러오기
    @SuppressLint("Range")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("rrr12",PhotoList.toString())
        Glide.with(context)
            .load(PhotoList[position].url.regular)
            .placeholder(ColorDrawable(Color.parseColor(PhotoList[position].color)))
            .into(holder.binding.img1)

        // 이미지 클릭 시 뷰페이저에 화면 띄워주기
        // 문제 : 클릭 시 해당 사진이 아닌 첫 사진으로 먼저 띄워진다.
        // 로그 결과 : Glide 쪽에서 PhotoList가 1개의 이미지 값만 가지고 있다.
        binding.img1.setOnClickListener{v ->
            var intent = Intent(context, MainActivity2::class.java)
            //v.context.startActivity(intent)
            //intent.putExtra("imageUrl",PhotoList[position].url.full)
            intent.putParcelableArrayListExtra("photoList", ArrayList(PhotoList))
            intent.putExtra("photoPos", position)
            context.startActivity(intent)
            Log.d("rrr1",PhotoList.toString())
        }
    }
    override fun getItemCount(): Int {
        return PhotoList.size
    }
}