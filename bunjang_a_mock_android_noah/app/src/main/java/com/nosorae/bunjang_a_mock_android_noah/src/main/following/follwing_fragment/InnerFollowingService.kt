package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.AddItemRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InnerFollowingService(val view: InnerFollowingFragmentView) {

    fun tryGetInnerFollowing(){
        val retrofitInterface = ApplicationClass.sRetrofit.create(InnerFollowingRetrofitInterface::class.java)
        retrofitInterface.getInnerFollowing().enqueue(object :
                Callback<GetInnerResponse> {
            override fun onResponse(call: Call<GetInnerResponse>, response: Response<GetInnerResponse>) {
                Log.d("additem", "add item onResponse 도착")
                view.onGetInnerSuccess(response.body() as GetInnerResponse)
            }

            override fun onFailure(call: Call<GetInnerResponse>, t: Throwable) {
                Log.d("additem", "add item onFailure 도착")
                view.onGetInnerFailure(t.message ?: "통신 오류")
            }
        })
    }
}