package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse

interface RecommendFragmentView {

    fun onGetRecommendSuccess(response: GetRecommendResponse)
    fun onGetRecommendFailure(message: String)
}