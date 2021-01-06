package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteResponse

interface HomeFragmentView {
    fun onGetItemSuccess(response: GetItemResponse)
    fun onGetItemFailure(message: String)

    fun onGetCollectionSuccess(response: GetCollectionResponse)
    fun onGetCollectionFailure(message: String)

    fun onPostFavoriteSuccess(response: PostFavoriteResponse)
    fun onPostFavoriteFailure(message: String)
}