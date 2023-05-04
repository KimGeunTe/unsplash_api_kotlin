package com.example.unsplash_api

import com.example.unsplash_api.model.PhotoData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
// https://api.unsplash.com/photos?client_id=YyF_mgiNePt_wj7AcCS8nIqb-tb1y7PuZCFKQ5mctjM
interface Retrofit_Key_Interface {
    // Key
    @GET("photos/?client_id=uLZNuKg1tYoGqAo8RJM1wpx2IVd7HdyZaL4B5kcaYVY")
    fun getPhoto(
        // 첫 페이지
        @Query("page") page:Int,
        // 끝 페이지
        @Query("per_page") perPage:Int,
        // 사진 정렬
        @Query("order_by") oederBy:String
    ): Call<MutableList<PhotoData>>
}