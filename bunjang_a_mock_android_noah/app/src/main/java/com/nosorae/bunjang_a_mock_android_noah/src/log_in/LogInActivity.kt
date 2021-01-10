package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityLogInBinding
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.dialog.LogInDialog
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.PostKakaoSignUpRequest
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.MainActivity
import com.nosorae.bunjang_a_mock_android_noah.util.LoadingDialog

class LogInActivity : BaseActivity<ActivityLogInBinding>(ActivityLogInBinding::inflate), LogInActivityView {
    private lateinit var dlg : Dialog //부모 액티비티의 context 가 들어감
    private var pageItemList = ArrayList<LogInViewPagerItem>()
    private lateinit var myAdapter : LogInViewPagerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jwtToken: String? = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, null)
        if (jwtToken != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        binding.imageButtonLogInKakao.setOnClickListener {
            // 카카오톡으로 로그인
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    //Log.e("kakao", "로그인 실패", error)
                    showCustomToast("로그인 실패 ${error}")
                }
                else if (token != null) {
                    Log.i("kakao", "로그인 성공 ${token.accessToken}")
                    //showCustomToast("로그인 성공 ${token.accessToken}")
                    LogInService(this).tryPostKakaoSignUp(PostKakaoSignUpRequest(token.accessToken))
                }
            }

            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }








        //데이터 리스트 준비
        pageItemList.add(LogInViewPagerItem(R.drawable.log_in_view_pager1))
        pageItemList.add(LogInViewPagerItem(R.drawable.log_in_view_pager2))
        pageItemList.add(LogInViewPagerItem(R.drawable.log_in_view_pager3))
        pageItemList.add(LogInViewPagerItem(R.drawable.log_in_view_pager4))
        myAdapter = LogInViewPagerAdapter(this, pageItemList)
        var viewPager = binding.viewPagerIntro.apply {
            adapter = myAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        var tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
        }.attach()

        binding.textViewLogInOtherWay.setOnClickListener {
            LogInDialog(this).showLogInDialog()
            //LoadingDialog(this).show()
            //startActivity(Intent(this, MainActivity::class.java))
            //finish()
        }









    }

    override fun onPostKakaoSignUpSuccess(response: KakaoSignUpResponse) {
        Log.d("mykakao", "카카오 성공이요!! jwt : ${response.jwt}")
        val editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString(ApplicationClass.X_ACCESS_TOKEN, response.jwt)
        editor.apply()
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    override fun onPostKakaoSignUpFailure(message: String) {
        Log.d("mykakao", "카카오 실패요!! error_message : ${message}")
    }
}
