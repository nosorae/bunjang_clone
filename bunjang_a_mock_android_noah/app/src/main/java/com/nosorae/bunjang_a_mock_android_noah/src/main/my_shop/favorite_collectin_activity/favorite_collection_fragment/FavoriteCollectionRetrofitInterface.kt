package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.*
import retrofit2.Call
import retrofit2.http.*

interface FavoriteCollectionRetrofitInterface {

    @GET("collections")
    fun getCollection() : Call<GetFavoriteCollectionResponse>

    @POST("collections")
    fun postCollection(@Body param: PostFavoriteCollectionRequest) : Call<PostFavoriteCollectionResponse>

    @DELETE("/collections/{collectionId}")
    fun deleteCollection(@Path("collectionId") collectionId: Int) : Call<DeleteFavoriteCollectionResponse>

    @PATCH("/collections/{collectionId}/name")
    fun patchCollection(@Path("collectionId") collectionId: Int, @Body param: PatchFavoriteCollectionRequest) : Call<PatchFavoriteCollectionResponse>
}