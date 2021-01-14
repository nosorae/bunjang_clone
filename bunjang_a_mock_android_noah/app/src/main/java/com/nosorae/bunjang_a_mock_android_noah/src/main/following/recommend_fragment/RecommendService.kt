package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecommendService(val view: RecommendFragmentView) {

    fun tryGetRecommend(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(RecommendRetrofitInterface::class.java)
        homeRetrofitInterface.getRecommend().enqueue(object : Callback<GetRecommendResponse> {
            override fun onResponse(call: Call<GetRecommendResponse>, response: Response<GetRecommendResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetRecommendSuccess(response.body() as GetRecommendResponse)
                }

            }

            override fun onFailure(call: Call<GetRecommendResponse>, t: Throwable) {
                view.onGetRecommendFailure(t.message ?: "통신 오류")
            }
        })
    }
}