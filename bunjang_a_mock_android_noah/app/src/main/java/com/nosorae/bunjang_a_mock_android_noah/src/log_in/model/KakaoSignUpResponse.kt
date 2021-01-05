package com.nosorae.bunjang_a_mock_android_noah.src.log_in.model

data class KakaoSignUpResponse(
    val code: Int,
    val isSuccess: Boolean,
    val jwt: String,
    val message: String,
    val userInfo: UserInfo
)