package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {

    @GET("products")
    fun getItem(@Query("page") page : Int, @Query("size") size : Int) : Call<GetItemResponse>

    @POST("product/:productId/pick")
    fun postItem(@Body param: PostFavoriteRequest) : Call<PostFavoriteResponse>

    @GET("collections")
    fun getCollection() : Call<GetCollectionResponse>

}