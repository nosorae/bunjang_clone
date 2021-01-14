package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity

import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OneCategoryRetrofitInterface {

    @GET("products/categories")
    fun getItem(@Query("category") category: Int) : Call<OneCategoryResponse>
}