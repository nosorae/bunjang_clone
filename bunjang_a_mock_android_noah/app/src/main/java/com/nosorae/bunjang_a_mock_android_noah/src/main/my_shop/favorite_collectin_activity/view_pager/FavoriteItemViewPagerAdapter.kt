package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.view_pager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.RecentlyViewItemFragment


class FavoriteItemViewPagerAdapter(fragmentActivity: FragmentActivity):
        FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FavoriteCollectionFragment()
            else -> RecentlyViewItemFragment()

        }
    }
}