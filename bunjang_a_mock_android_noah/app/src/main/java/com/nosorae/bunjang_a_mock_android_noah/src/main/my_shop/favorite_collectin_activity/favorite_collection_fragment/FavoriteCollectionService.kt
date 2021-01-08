package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteCollectionService(val view: FavoriteCollectionFragmentView) {


    fun tryGetCollection(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(FavoriteCollectionRetrofitInterface::class.java)
        homeRetrofitInterface.getCollection().enqueue(object : Callback<GetFavoriteCollectionResponse> {
            override fun onResponse(call: Call<GetFavoriteCollectionResponse>, response: Response<GetFavoriteCollectionResponse>) {
                Log.d("api", "onResponse 도착 ${response.message()}")
                if(response.body() != null){
                    view.onGetCollectionSuccess(response.body() as GetFavoriteCollectionResponse)
                }

            }

            override fun onFailure(call: Call<GetFavoriteCollectionResponse>, t: Throwable) {
                view.onGetCollectionFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostCollection(param: String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(FavoriteCollectionRetrofitInterface::class.java)
        homeRetrofitInterface.postCollection(PostFavoriteCollectionRequest(param)).enqueue(object : Callback<PostFavoriteCollectionResponse> {
            override fun onResponse(call: Call<PostFavoriteCollectionResponse>, response: Response<PostFavoriteCollectionResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onPostCollectionSuccess(response.body() as PostFavoriteCollectionResponse)
                }

            }

            override fun onFailure(call: Call<PostFavoriteCollectionResponse>, t: Throwable) {
                view.onPostCollectionFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryDeleteCollection(collectionId: Int){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(FavoriteCollectionRetrofitInterface::class.java)
        homeRetrofitInterface.deleteCollection(collectionId).enqueue(object : Callback<DeleteFavoriteCollectionResponse> {
            override fun onResponse(call: Call<DeleteFavoriteCollectionResponse>, response: Response<DeleteFavoriteCollectionResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onDeleteCollectionSuccess(response.body() as DeleteFavoriteCollectionResponse)
                }

            }

            override fun onFailure(call: Call<DeleteFavoriteCollectionResponse>, t: Throwable) {
                view.onDeleteCollectionFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPatchCollection(param: Int, body: String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(FavoriteCollectionRetrofitInterface::class.java)
        homeRetrofitInterface.patchCollection(param, PatchFavoriteCollectionRequest(body)).enqueue(object : Callback<PatchFavoriteCollectionResponse> {
            override fun onResponse(call: Call<PatchFavoriteCollectionResponse>, response: Response<PatchFavoriteCollectionResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onPatchCollectionSuccess(response.body() as PatchFavoriteCollectionResponse)
                }

            }

            override fun onFailure(call: Call<PatchFavoriteCollectionResponse>, t: Throwable) {
                view.onPatchCollectionFailure(t.message ?: "통신 오류")
            }
        })
    }





}