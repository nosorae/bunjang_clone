package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model.GetSellerProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerProfileService(val view: SellerProfileActivityView) {

    fun trySellerGetProfile(storeId: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(SellerProfileRetrofitInterface::class.java)
        homeRetrofitInterface.getProfile(storeId).enqueue(object : Callback<GetSellerProfileResponse> {
            override fun onResponse(call: Call<GetSellerProfileResponse>, response: Response<GetSellerProfileResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetSellerProfileSeccess(response.body() as GetSellerProfileResponse)
                }

            }

            override fun onFailure(call: Call<GetSellerProfileResponse>, t: Throwable) {
                view.onGetSellerProfileFailure(t.message ?: "통신 오류")
            }
        })
    }
}