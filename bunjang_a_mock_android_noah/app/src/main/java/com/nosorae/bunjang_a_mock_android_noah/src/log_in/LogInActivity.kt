package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.AuthType
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.util.Utility
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityLogInBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.MainActivity

class LogInActivity : BaseActivity<ActivityLogInBinding>(ActivityLogInBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.imageButtonLogInKakao.setOnClickListener {
            // 카카오톡으로 로그인
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e("kakao", "로그인 실패", error)
                    showCustomToast("로그인 실패 ${error}")
                }
                else if (token != null) {
                    Log.i("kakao", "로그인 성공 ${token.accessToken}")
                    showCustomToast("로그인 성공 ${token.accessToken}")
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                }
            }

            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }
}