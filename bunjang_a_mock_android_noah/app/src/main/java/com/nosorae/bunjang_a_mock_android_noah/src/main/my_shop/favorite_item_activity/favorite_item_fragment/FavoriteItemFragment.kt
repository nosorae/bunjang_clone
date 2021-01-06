package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment

import android.os.Bundle

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentFavoriteItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.recycler_view.GalleryRecyclerViewSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view.FavoriteItemRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view.FavoriteItemRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.favorite_item_fragment.recycler_view.FavoriteItemRecyclerViewSpacing

class FavoriteItemFragment :
    BaseFragment<FragmentFavoriteItemBinding>(FragmentFavoriteItemBinding::bind, R.layout.fragment_favorite_item) {

    private var recyclerItemList = ArrayList<FavoriteItemRecyclerViewItem>()
    private lateinit var recyclerAdapter : FavoriteItemRecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        for(x in 1..10){
            val temp = FavoriteItemRecyclerViewItem("https://image.aladin.co.kr/product/3037/22/cover500/8968225419_1.jpg", "실험이름", 123)
            recyclerItemList.add(temp)
        }
        recyclerAdapter = FavoriteItemRecyclerViewAdapter(context, recyclerItemList)
        binding.favoriteRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(FavoriteItemRecyclerViewSpacing(2, 2))
        }


    }


}