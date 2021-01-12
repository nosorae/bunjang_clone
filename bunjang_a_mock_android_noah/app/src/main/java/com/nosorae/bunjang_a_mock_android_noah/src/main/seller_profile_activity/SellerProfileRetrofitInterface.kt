package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model.GetSellerProfileResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SellerProfileRetrofitInterface {

    @GET("stores/{storeId}")
    fun getProfile(@Path("storeId") storeId: Int) : Call<GetSellerProfileResponse>
}