package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneCategoryService(val view: OneCategoryActivityView) {

    fun tryGetOneCategory(category: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(OneCategoryRetrofitInterface::class.java)
        homeRetrofitInterface.getItem(1, 100, category).enqueue(object : Callback<OneCategoryResponse> {
            override fun onResponse(call: Call<OneCategoryResponse>, response: Response<OneCategoryResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetOneCategorySuccess(response.body() as OneCategoryResponse)
                }

            }

            override fun onFailure(call: Call<OneCategoryResponse>, t: Throwable) {
                view.onGetOneCategoryFailure(t.message ?: "통신 오류")
            }
        })
    }
}