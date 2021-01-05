package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.PostKakaoSignUpRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInService(val view: LogInActivityView) {


    fun tryPostKakaoSignUp(body: PostKakaoSignUpRequest){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(LogInRetrofitInterface::class.java)
        homeRetrofitInterface.postKakaoSignUp(body).enqueue(object :
            Callback<KakaoSignUpResponse> {
            override fun onResponse(call: Call<KakaoSignUpResponse>, response: Response<KakaoSignUpResponse>) {
                    view.onPostKakaoSignUpSuccess(response.body() as KakaoSignUpResponse)
            }

            override fun onFailure(call: Call<KakaoSignUpResponse>, t: Throwable) {
                view.onPostKakaoSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }
}