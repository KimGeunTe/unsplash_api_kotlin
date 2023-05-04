package com.example.unsplash_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.unsplash_api.databinding.ActivityMainBinding
import com.example.unsplash_api.model.PhotoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var Photo_List:MutableList<PhotoData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // RecyclerView 연결
        // StaggeredGridLayoutManager은 너비와크기를 자동으로 설정해준다.
        // android:scaleType="centerCrop"은 가로/세로의 길이 중 짧은 쪽을 레이아웃에 꽉 차게 크기를 맞춰서 출력한다.
        val gridLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.Main2Rv.layoutManager = gridLayoutManager
        val gridAdapter = RV_Adapter(this, Photo_List)
        binding.Main2Rv.adapter = gridAdapter

        // RecyclerView 보이게
        binding.Main2Rv.visibility = View.VISIBLE

        // Retrofit 연결
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 안드로이드 책 600쪽
        var networkService: Retrofit_Key_Interface = retrofit.create(Retrofit_Key_Interface::class.java)

        val userListCall = networkService.getPhoto(1, 30, "latest")
        userListCall.enqueue(object : Callback<MutableList<PhotoData>> {
            override fun onResponse(
                call: Call<MutableList<PhotoData>>,
                response: Response<MutableList<PhotoData>>
            ) {
                if (response.isSuccessful) {
                    Photo_List.clear()
                    response.body()?.let { Photo_List.addAll(it) }
                    gridAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MutableList<PhotoData>>, t: Throwable) {
                call.cancel()
                Log.d("retrofit", "실패")
            }
        })
    }
}