package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse

interface LogInActivityView {

    fun onPostKakaoSignUpSuccess(response: KakaoSignUpResponse)

    fun onPostKakaoSignUpFailure(message: String)
}