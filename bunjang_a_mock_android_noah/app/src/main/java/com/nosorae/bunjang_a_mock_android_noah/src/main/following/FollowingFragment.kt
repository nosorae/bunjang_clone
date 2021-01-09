package com.nosorae.bunjang_a_mock_android_noah.src.main.following

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentFollowingBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.view_pager.FollowingViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.view_pager.FavoriteItemViewPagerAdapter

class FollowingFragment :
    BaseFragment<FragmentFollowingBinding>(FragmentFollowingBinding::bind, R.layout.fragment_following)
     {

    val tabTextList = arrayOf("내피드", "팔로잉", "추천")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.followingViewPager.adapter = FollowingViewPagerAdapter(super.getActivity()!!)

        TabLayoutMediator(binding.followingTabLayout,binding.followingViewPager) {
                tab, position ->
            //tab.setIcon(tabIconList[position])
            tab.text = tabTextList[position]
        }.attach()



    }


}