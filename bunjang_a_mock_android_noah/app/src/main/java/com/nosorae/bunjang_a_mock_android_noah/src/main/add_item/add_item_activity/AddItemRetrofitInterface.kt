package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity


import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.UpdateItemRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.UpdateItemResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AddItemRetrofitInterface {

    @POST("products")
    fun postAddItem(@Body params : AddItemRequest) : Call<AddItemResponse>

    @PUT("products/{productId}")
    fun putUpdateItem(@Path("productId")  productId : Int , @Body params: UpdateItemRequest): Call<UpdateItemResponse>
}