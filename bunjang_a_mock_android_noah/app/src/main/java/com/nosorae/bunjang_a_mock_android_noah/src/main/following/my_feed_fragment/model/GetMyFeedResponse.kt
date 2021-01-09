package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model

data class GetMyFeedResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<GetMyFeedResult>
)