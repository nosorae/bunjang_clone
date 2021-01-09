package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import retrofit2.Call
import retrofit2.http.GET


interface MyFeedRetrofitInterface {



    @GET("follow/feed")
    fun getMyFeed(): Call<GetMyFeedResponse>
}