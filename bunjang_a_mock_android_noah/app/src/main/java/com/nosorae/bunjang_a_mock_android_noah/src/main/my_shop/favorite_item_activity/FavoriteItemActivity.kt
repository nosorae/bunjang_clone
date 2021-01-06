package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityFavoriteItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.FavoriteItemFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.view_pager.FavoriteItemViewPagerAdapter

class FavoriteItemActivity : BaseActivity<ActivityFavoriteItemBinding>(ActivityFavoriteItemBinding::inflate) {

    private val tabTextList = arrayListOf("찜", "최근 본 상품")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.favoriteItemButtonBack.setOnClickListener {
            finish()
        }


        binding.favoriteItemViewPager.adapter = FavoriteItemViewPagerAdapter(this)

        TabLayoutMediator(binding.favoriteItemTabLayout,binding.favoriteItemViewPager) {
            tab, position ->
            //tab.setIcon(tabIconList[position])
            tab.text = tabTextList[position]
        }.attach()





    }
}