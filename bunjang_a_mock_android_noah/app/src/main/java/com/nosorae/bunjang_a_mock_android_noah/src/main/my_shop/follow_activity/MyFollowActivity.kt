package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.follow_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityMyFollowBinding

class MyFollowActivity : BaseActivity<ActivityMyFollowBinding>(ActivityMyFollowBinding::inflate)  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.myFollowButtonBack.setOnClickListener {
            finish()
        }

    }
}