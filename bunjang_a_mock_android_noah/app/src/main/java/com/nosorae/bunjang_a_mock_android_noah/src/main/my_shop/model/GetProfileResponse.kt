package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model

data class GetProfileResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: GetProfileResult
)