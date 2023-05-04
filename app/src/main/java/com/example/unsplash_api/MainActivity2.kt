@file:Suppress("DEPRECATION")

package com.example.unsplash_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.unsplash_api.databinding.ActivityMain2Binding
import com.example.unsplash_api.model.PhotoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val photoList = intent.getParcelableArrayListExtra<PhotoData>("photoList") as ArrayList<PhotoData>
        val photoPos = intent.getIntExtra("photoPos", 0)
        Log.d("rrr",photoList.toString())
        // ViewPager 연결
        var vpAdapter = VP_Adapter(this, photoList)
        binding.Main2Vp.adapter = vpAdapter
        binding.Main2Vp.visibility = View.VISIBLE
        binding.Main2Vp.setCurrentItem(photoPos, false)



    }
}