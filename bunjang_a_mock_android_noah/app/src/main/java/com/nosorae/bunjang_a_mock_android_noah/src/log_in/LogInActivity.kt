package com.nosorae.bunjang_a_mock_android_noah.src.log_in

import android.content.Intent
import android.os.Bundle
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityLogInBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.MainActivity

class LogInActivity : BaseActivity<ActivityLogInBinding>(ActivityLogInBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.logIn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
}