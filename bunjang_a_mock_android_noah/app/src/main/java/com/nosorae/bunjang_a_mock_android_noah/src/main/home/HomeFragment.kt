package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentHomeBinding
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.category_activity.AllCategoryActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerItem

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
        HomeFragmentView  {
    private var pageItemList = ArrayList<HomeViewPagerItem>()
    private var recyclerItemList = ArrayList<GetItemResult>()
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

        //아이템 목록 가져오기
        HomeService(this).tryGetUsers()

        //전체 카테고리 리스너
        binding.homeImageViewCategoryAll.setOnClickListener {
            startActivity(Intent(context, AllCategoryActivity::class.java))
        }


        //좋아요 클릭


    }

    override fun onGetItemSuccess( response: GetItemResponse) {

        Log.d("api", response.message)
       for(item in response.result){
           recyclerItemList.add(item)
       }
        recyclerAdapter = HomeRecyclerViewAdapter(context, recyclerItemList)
        binding.homeRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
            //addItemDecoration(HomeRecyclerViewSpacing(16, 16))
        }
        //recyclerAdapter.notifyDataSetChanged()
    }

    override fun onGetItemFailure(message: String) {
        Log.d("api", message)
    }

    override fun onPostFavoriteSuccess(response: PostFavoriteResponse) {
        Log.d("favorite", response.message)
    }

    override fun onPostFavoriteFailure(message: String) {
        Log.d("favorite", message)
    }

    override fun onGetCollectionSuccess(response: GetCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }
}