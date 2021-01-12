package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model

data class GetSellerProfileResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: GetSellerProfileResult
)