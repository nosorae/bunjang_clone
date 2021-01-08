package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityFavoriteCollectionBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.view_pager.FavoriteItemViewPagerAdapter

class FavoriteCollectionActivity : BaseActivity<ActivityFavoriteCollectionBinding>(ActivityFavoriteCollectionBinding::inflate) {

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