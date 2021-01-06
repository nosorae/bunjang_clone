package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyShopBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.configuration_activity.MyShopConfigurationActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.FavoriteItemActivity

class MyShopFragment :
    BaseFragment<FragmentMyShopBinding>(FragmentMyShopBinding::bind, R.layout.fragment_my_shop) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButtonPreferences.setOnClickListener {
            startActivity(Intent(context, MyShopConfigurationActivity::class.java))
        }
        binding.textViewLike.setOnClickListener {
            startActivity(Intent(context, FavoriteItemActivity::class.java))
        }


    }
}