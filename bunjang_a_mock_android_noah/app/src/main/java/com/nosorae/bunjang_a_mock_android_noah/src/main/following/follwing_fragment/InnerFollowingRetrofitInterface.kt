package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResponse
import retrofit2.Call
import retrofit2.http.GET


interface InnerFollowingRetrofitInterface {

    @GET("follow/following")
    fun getInnerFollowing() : Call<GetInnerResponse>
}