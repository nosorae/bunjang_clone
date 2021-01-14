package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendRetrofitInterface {

    @GET("follow/recommendation")
    fun getRecommend() : Call<GetRecommendResponse>
}