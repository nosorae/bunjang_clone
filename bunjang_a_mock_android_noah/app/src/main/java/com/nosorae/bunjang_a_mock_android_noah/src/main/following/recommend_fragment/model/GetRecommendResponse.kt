package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model

data class GetRecommendResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<GetRecommendResult>
)