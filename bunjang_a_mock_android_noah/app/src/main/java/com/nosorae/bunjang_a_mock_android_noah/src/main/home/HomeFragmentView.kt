package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse

interface HomeFragmentView {
    fun onGetItemSuccess(response: GetItemResponse)
    fun onGetItemFailure(message: String)
}