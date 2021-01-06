package com.nosorae.bunjang_a_mock_android_noah.src.main.home.model

data class GetCollectionResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)