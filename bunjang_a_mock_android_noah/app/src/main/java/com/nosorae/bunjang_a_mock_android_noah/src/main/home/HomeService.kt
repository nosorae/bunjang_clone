package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

    fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getItem(1, 10).enqueue(object : Callback<GetItemResponse> {
            override fun onResponse(call: Call<GetItemResponse>, response: Response<GetItemResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetItemSuccess(response.body() as GetItemResponse)
                }

            }

            override fun onFailure(call: Call<GetItemResponse>, t: Throwable) {
                view.onGetItemFailure(t.message ?: "통신 오류")
            }
        })
    }

}