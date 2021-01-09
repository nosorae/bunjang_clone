package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment

import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyFeedService(val view: MyFeedFragmentView)  {

    fun tryGetMyFeed(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(MyFeedRetrofitInterface::class.java)
        homeRetrofitInterface.getMyFeed().enqueue(object :
            Callback<GetMyFeedResponse> {
            override fun onResponse(call: Call<GetMyFeedResponse>, response: Response<GetMyFeedResponse>) {
                view.onGetMyFeedSuccess(response.body() as GetMyFeedResponse)
            }

            override fun onFailure(call: Call<GetMyFeedResponse>, t: Throwable) {
                view.onGetMyFeedFailure(t.message ?: "통신 오류")
            }
        })
    }
}