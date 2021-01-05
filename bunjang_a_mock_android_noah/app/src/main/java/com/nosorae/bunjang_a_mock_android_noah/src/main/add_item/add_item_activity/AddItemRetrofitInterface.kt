package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity


import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AddItemRetrofitInterface {

    @POST("products")
    fun postAddItem(@Body params : AddItemRequest) : Call<AddItemResponse>
}