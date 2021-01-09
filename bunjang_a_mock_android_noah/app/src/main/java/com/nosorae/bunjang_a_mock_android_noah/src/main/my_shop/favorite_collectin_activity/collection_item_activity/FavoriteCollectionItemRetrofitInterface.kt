package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FavoriteCollectionItemRetrofitInterface {

    @GET("collections/{collectionId}/pick")
    fun getCollectionItem(@Path("collectionId") collectionId: Int, @Query("saleState") saleState: Char): Call<FavoriteCollectionItemResponse>

}