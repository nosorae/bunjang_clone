package com.nosorae.bunjang_a_mock_android_noah.src.main.following.view_pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.InnerFollowingFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.MyFeedFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.RecommendFragment

class FollowingViewPagerAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyFeedFragment()
            1 -> InnerFollowingFragment()
            else -> RecommendFragment()
        }
    }

}
