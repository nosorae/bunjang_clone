package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.PostKakaoSignUpRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LogInRetrofitInterface {
    @POST("kakao-sign-in")
    fun postKakaoSignUp(@Body params : PostKakaoSignUpRequest) : Call<KakaoSignUpResponse>
}