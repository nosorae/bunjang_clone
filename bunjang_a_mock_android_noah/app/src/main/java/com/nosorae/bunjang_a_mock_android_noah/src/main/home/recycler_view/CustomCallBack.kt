package com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view


import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteResponse

interface CustomCallBack {

    fun onFavoriteSuccess()
    fun onFavoriteFailure(message: String)
}