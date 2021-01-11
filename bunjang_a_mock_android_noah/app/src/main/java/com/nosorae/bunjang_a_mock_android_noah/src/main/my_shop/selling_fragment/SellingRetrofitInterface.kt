package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SellingRetrofitInterface {

    @GET("profile/products")
    fun getSelling(@Query("saleState") saleState: Char) : Call<GetMySellingResponse>
}