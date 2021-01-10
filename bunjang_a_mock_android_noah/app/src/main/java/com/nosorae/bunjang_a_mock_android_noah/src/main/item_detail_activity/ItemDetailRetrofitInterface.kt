package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity


import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ItemDetailRetrofitInterface {

    @GET("products/{productId}")
    fun getItemDetail(@Path("productId") productId: Int): Call<GetItemDetailResponse>

    @POST("follow/{storeId}")
    fun postFollow(@Path("storeId") storeId: Int): Call<PostFollowResponse>
}