package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity


import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemDetailRetrofitInterface {

    @GET("products/{productId}")
    fun getItemDetail(@Path("productId") productId: Int): Call<GetItemDetailResponse>
}