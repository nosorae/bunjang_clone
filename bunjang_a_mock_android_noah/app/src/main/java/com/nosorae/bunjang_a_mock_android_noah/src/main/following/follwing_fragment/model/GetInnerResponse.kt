package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model

data class GetInnerResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<GetInnerResult>
)