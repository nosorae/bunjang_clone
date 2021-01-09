package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteCollectionItemService(val view: FavoriteCollectionItemActivityView) {

    fun tryGetCollectionItem(collectionId: Int, param: Char){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(FavoriteCollectionItemRetrofitInterface::class.java)
        homeRetrofitInterface.getCollectionItem(collectionId, param).enqueue(object : Callback<FavoriteCollectionItemResponse> {
            override fun onResponse(call: Call<FavoriteCollectionItemResponse>, itemResponse: Response<FavoriteCollectionItemResponse>) {
                Log.d("api", "onResponse 도착 ${itemResponse.isSuccessful}")
                if(itemResponse.body() != null){
                    view.onGetCollectionItemSuccess(itemResponse.body() as FavoriteCollectionItemResponse)
                }

            }

            override fun onFailure(call: Call<FavoriteCollectionItemResponse>, t: Throwable) {
                view.onGetCollectionItemFailure(t.message ?: "통신 오류")
            }
        })
    }
}