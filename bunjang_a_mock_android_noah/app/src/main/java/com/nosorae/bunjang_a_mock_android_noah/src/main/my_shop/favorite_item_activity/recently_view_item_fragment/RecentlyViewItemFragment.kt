package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.recently_view_item_fragment

import android.os.Bundle

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentRecentlyViewItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view.FavoriteItemRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view.FavoriteItemRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view.FavoriteItemRecyclerViewSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.recently_view_item_fragment.recycler_view.RecentlyViewItemRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.recently_view_item_fragment.recycler_view.RecentlyViewItemRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.recently_view_item_fragment.recycler_view.RecentlyViewItemRecyclerViewSpacing

class RecentlyViewItemFragment :
        BaseFragment<FragmentRecentlyViewItemBinding>(FragmentRecentlyViewItemBinding::bind, R.layout.fragment_recently_view_item) {

    private var recyclerItemList = ArrayList<RecentlyViewItemRecyclerViewItem>()
    private lateinit var recyclerAdapter : RecentlyViewItemRecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for(x in 1..10){
            val temp = RecentlyViewItemRecyclerViewItem("https://image.aladin.co.kr/product/3037/22/cover500/8968225419_1.jpg", "실험이름", 123)
            recyclerItemList.add(temp)
        }
        recyclerAdapter =RecentlyViewItemRecyclerViewAdapter(context, recyclerItemList)
        binding.recentlyViewRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(RecentlyViewItemRecyclerViewSpacing(2, 2))
        }



    }


}