package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.DeleteItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyShopService(val view: MyShopFragmentView) {

    fun tryGetProfile(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(MyShopRetrofitInterface::class.java)
        homeRetrofitInterface.getProfile().enqueue(object : Callback<GetProfileResponse> {
            override fun onResponse(call: Call<GetProfileResponse>, response: Response<GetProfileResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetProfileSeccess(response.body() as GetProfileResponse)
                }

            }

            override fun onFailure(call: Call<GetProfileResponse>, t: Throwable) {
                view.onGetProfileFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryDeleteItem(itemId: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(MyShopRetrofitInterface::class.java)
        homeRetrofitInterface.deleteItem(itemId).enqueue(object : Callback<DeleteItemResponse> {
            override fun onResponse(call: Call<DeleteItemResponse>, response: Response<DeleteItemResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onDeleteItemSeccess(response.body() as DeleteItemResponse)
                }

            }

            override fun onFailure(call: Call<DeleteItemResponse>, t: Throwable) {
                view.onDeleteItemFailure(t.message ?: "통신 오류")
            }
        })
    }
}