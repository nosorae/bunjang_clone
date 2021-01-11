package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellingService(val view: SellingFragmentView) {

    fun tryGetSelling(saleState: Char){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(SellingRetrofitInterface::class.java)
        homeRetrofitInterface.getSelling(saleState).enqueue(object : Callback<GetMySellingResponse> {
            override fun onResponse(call: Call<GetMySellingResponse>, response: Response<GetMySellingResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetSellingSeccess(response.body() as GetMySellingResponse)
                }

            }

            override fun onFailure(call: Call<GetMySellingResponse>, t: Throwable) {
                view.onGetSellingFailure(t.message ?: "통신 오류")
            }
        })
    }
}