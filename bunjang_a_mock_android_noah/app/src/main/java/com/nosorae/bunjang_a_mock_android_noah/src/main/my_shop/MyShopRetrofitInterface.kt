package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop


import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import retrofit2.Call
import retrofit2.http.GET


interface MyShopRetrofitInterface {

    @GET("profile/info")
    fun getProfile() : Call<GetProfileResponse>

}