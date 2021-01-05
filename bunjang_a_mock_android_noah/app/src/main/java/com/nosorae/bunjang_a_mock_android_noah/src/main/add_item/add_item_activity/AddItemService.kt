package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity

import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddItemService(val view : AddItemActivityView) {

    public fun tryPostAddItem(body: AddItemRequest){
        val retrofitInterface = ApplicationClass.sRetrofit.create(AddItemRetrofitInterface::class.java)
        retrofitInterface.postAddItem(body).enqueue(object :
            Callback<AddItemResponse> {
            override fun onResponse(call: Call<AddItemResponse>, response: Response<AddItemResponse>) {
                view.onPostAddItemSuccess(response.body() as AddItemResponse)
            }

            override fun onFailure(call: Call<AddItemResponse>, t: Throwable) {
                view.onPostAddItemFailure(t.message ?: "통신 오류")
            }
        })
    }
}