package com.nosorae.bunjang_a_mock_android_noah.src.log_in.model

import com.google.gson.annotations.SerializedName

data class PostKakaoSignUpRequest(
    @SerializedName("kakaoToken") val token: String
)