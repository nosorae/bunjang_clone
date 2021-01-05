package com.nosorae.bunjang_a_mock_android_noah.config

import android.util.Log
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sSharedPreferences.getString(X_ACCESS_TOKEN, null)
        if (jwtToken != null) {
            Log.d("mykakao", "jwt토큰 인터셉터 호출됨 "+jwtToken)
            builder.addHeader("X-ACCESS-TOKEN", jwtToken)
        }
        else{
          builder.addHeader("X-ACCESS-TOKEN", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNjA5NjU2OTgzLCJleHAiOjE2NDExOTI5ODMsInN1YiI6InVzZXJJbmZvIn0.HPwRsAVsblt3BOhkTx5ZtluDyOAC1oUko4vNbpV27Mg")
        }

        return chain.proceed(builder.build())
    }
}