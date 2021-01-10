package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity

import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.LogInActivityView
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.LogInRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.PostKakaoSignUpRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemDetailService(val view: ItemDetailActivityView) {

    fun tryGetItemDetail(itemId: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(ItemDetailRetrofitInterface::class.java)
        homeRetrofitInterface.getItemDetail(itemId).enqueue(object : Callback<GetItemDetailResponse> {
            override fun onResponse(call: Call<GetItemDetailResponse>, response: Response<GetItemDetailResponse>) {
                view.onGetItemDetailSignUpSuccess(response.body() as GetItemDetailResponse)
            }

            override fun onFailure(call: Call<GetItemDetailResponse>, t: Throwable) {
                view.onGetItemDetailSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostFollow(storeId: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(ItemDetailRetrofitInterface::class.java)
        homeRetrofitInterface.postFollow(storeId).enqueue(object : Callback<PostFollowResponse> {
            override fun onResponse(call: Call<PostFollowResponse>, response: Response<PostFollowResponse>) {
                view.onPostFollowSuccess(response.body() as PostFollowResponse)
            }

            override fun onFailure(call: Call<PostFollowResponse>, t: Throwable) {
                view.onPostFollowFailure(t.message ?: "통신 오류")
            }
        })
    }
}