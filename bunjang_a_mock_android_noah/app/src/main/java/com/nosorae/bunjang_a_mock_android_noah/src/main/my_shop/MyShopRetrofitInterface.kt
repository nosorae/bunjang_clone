package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop


import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.DeleteItemResponse
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path


interface MyShopRetrofitInterface {

    @GET("profile/info")
    fun getProfile() : Call<GetProfileResponse>

    @DELETE("products/{productId}")
    fun deleteItem(@Path("productId") productId : Int) : Call<DeleteItemResponse>

}