package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentHomeBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerItem

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
        HomeFragmentView {
    private var pageItemList = ArrayList<HomeViewPagerItem>()
    private var recyclerItemList = ArrayList<HomeRecyclerViewItem>()
    private lateinit var pageAdapter : HomeViewPagerAdapter
    private lateinit var recyclerAdapter : HomeRecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //뷰페이저 배너
        pageItemList.add(HomeViewPagerItem(R.drawable.home_banner1))
        pageItemList.add(HomeViewPagerItem(R.drawable.home_banner2))
        pageItemList.add(HomeViewPagerItem(R.drawable.home_banner3))
        pageItemList.add(HomeViewPagerItem(R.drawable.home_banner4))
        pageItemList.add(HomeViewPagerItem(R.drawable.home_banner5))
        pageItemList.add(HomeViewPagerItem(R.drawable.home_banner6))
        pageAdapter = HomeViewPagerAdapter(pageItemList)
        binding.homeViewPagerBanner.apply {
            adapter = pageAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }


        HomeService(this).tryGetUsers()

    }

    override fun onGetItemSuccess( response: GetItemResponse) {

        Log.d("api", "onGetItemSuccess도착")
       for(item in response.result){
           recyclerItemList.add(HomeRecyclerViewItem(item.productImgUrl,
                    item.productName, item.price, item.isPick))
       }
        recyclerAdapter = HomeRecyclerViewAdapter(context, recyclerItemList)
        binding.homeRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(HomeRecyclerViewSpacing(16, 16))
        }
        //recyclerAdapter.notifyDataSetChanged()
    }

    override fun onGetItemFailure(message: String) {

        Log.d("api", "onGetItemFailure도착")


    }
}