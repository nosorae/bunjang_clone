package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity

import android.os.Bundle
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityItemDetailBinding

class ItemDetailActivity
    : BaseActivity<ActivityItemDetailBinding>(ActivityItemDetailBinding::inflate)  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.activityItemDetailScrollView.setOnScrollChangeListener { view, i, i2, i3, i4 ->

        }



    }
}