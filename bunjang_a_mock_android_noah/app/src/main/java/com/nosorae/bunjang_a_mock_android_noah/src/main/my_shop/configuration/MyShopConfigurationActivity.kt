package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.configuration

import android.content.Intent

import android.os.Bundle
import android.util.Log
import com.kakao.sdk.user.UserApiClient
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityMyShopConfigurationBinding
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.LogInActivity

class MyShopConfigurationActivity : BaseActivity<ActivityMyShopConfigurationBinding>(ActivityMyShopConfigurationBinding::inflate)  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.imageViewButtonBack.setOnClickListener {
            finish()
        }
        binding.configureLayoutLogOut.setOnClickListener {
            // 로그아웃
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Log.e("kakao", "로그아웃 실패. SDK에서 토큰 삭제됨", error)

                }
                else {
                    Log.i("kakao", "로그아웃 성공. SDK에서 토큰 삭제됨")
                }
            }

            // 연결 끊기
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Log.e("kakao", "연결 끊기 실패", error)
                }
                else {
                    Log.i("kakao", "연결 끊기 성공. SDK에서 토큰 삭제 됨")
                }
            }

            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }
    }
}