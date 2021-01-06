package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import android.util.Log
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.LogInRetrofitInterface
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.PostKakaoSignUpRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class HomeService(val view: HomeFragmentView) {

    fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getItem(1, 10).enqueue(object : Callback<GetItemResponse> {
            override fun onResponse(call: Call<GetItemResponse>, response: Response<GetItemResponse>) {
                Log.d("api", "onResponse 도착 ${response.isSuccessful}")
                if(response.body() != null){
                    view.onGetItemSuccess(response.body() as GetItemResponse)
                }

            }

            override fun onFailure(call: Call<GetItemResponse>, t: Throwable) {
                view.onGetItemFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostFavorite(body: PostFavoriteRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postItem(body).enqueue(object :
                Callback<PostFavoriteResponse> {
            override fun onResponse(call: Call<PostFavoriteResponse>, response: Response<PostFavoriteResponse>) {
                Log.d("favorite", "Success : "+response.message())
                view.onPostFavoriteSuccess(response.body() as PostFavoriteResponse)
            }

            override fun onFailure(call: Call<PostFavoriteResponse>, t: Throwable) {
                Log.d("favorite", "Fail")
                view.onPostFavoriteFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetCollection(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getCollection().enqueue(object : Callback<GetCollectionResponse> {
            override fun onResponse(call: Call<GetCollectionResponse>, response: Response<GetCollectionResponse>) {
                Log.d("api", "onResponse 도착 ${response.message()}")
                if(response.body() != null){
                    view.onGetCollectionSuccess(response.body() as GetCollectionResponse)
                }

            }

            override fun onFailure(call: Call<GetCollectionResponse>, t: Throwable) {
                view.onGetCollectionFailure(t.message ?: "통신 오류")
            }
        })
    }



}