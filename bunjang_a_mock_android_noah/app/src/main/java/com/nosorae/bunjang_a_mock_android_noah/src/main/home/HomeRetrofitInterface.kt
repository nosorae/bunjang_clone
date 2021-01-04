package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomeRetrofitInterface {

    @GET("products")
    fun getItem(@Query("page") page : Int, @Query("size") size : Int) : Call<GetItemResponse>

}