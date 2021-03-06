package com.nosorae.bunjang_a_mock_android_noah.src.main.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlin.concurrent.thread
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.DialogLoadingBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentHomeBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.GlobalCustomToastBinding
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
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivity
import com.nosorae.bunjang_a_mock_android_noah.util.GlobalCheckDialog
import java.lang.Thread.sleep

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
        HomeFragmentView  {
    private var pageItemList = ArrayList<HomeViewPagerItem>()
    private var recyclerItemList = ArrayList<GetItemResult>()
    private lateinit var pageAdapter : HomeViewPagerAdapter
    private lateinit var recyclerAdapter : HomeRecyclerViewAdapter
    var check = true
    var isFirst = true
    lateinit var myThread : Thread

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //?????? ?????? ????????????????????? ??????????????? ??????
        binding.imageButtonBell.setOnClickListener {
            showLoadingDialog(context!!)
            /**
            val binding = GlobalCustomToastBinding.inflate(layoutInflater)
            val text = binding.globalCustomToastText
            text.text ="??? ???????????? ?????? ??????!" // toast_design.xml ???????????? ?????? ???????????? ?????? ??????
            val toast = Toast(context)
            toast.setGravity(Gravity.BOTTOM, 0, 0) // CENTER??? ???????????? 0, 0 ????????? ????????? ??????
            toast.setDuration(Toast.LENGTH_LONG)
            toast.setView(binding.globalCustomToastRoot)
            toast.show()
            **/
        }
        if(arguments != null) {
            val arg = arguments!!.getInt("itemId")
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra("itemId", arg)
            startActivity(intent)
            Log.d("isArgumentNull", "??????????????? ????????? ???????????? ??????")

        } else {
            Log.d("isArgumentNull", "??????????????? ????????? ?????????")
        }



        val swipeLayout = binding.swipeLayout

        swipeLayout.setColorSchemeResources(android.R.color.holo_red_light)
        swipeLayout.setOnRefreshListener {
            showLoadingDialog(context!!)
            HomeService(this).tryGetUsers()

            swipeLayout.isRefreshing = false

        }




        check = true
        myThread = thread {
            while(check) {
                sleep(3000)
                if(activity != null) {
                    activity!!.runOnUiThread {
                        if(check) {
                            var num = binding.homeViewPagerBanner.currentItem
                            if(num == 5){
                                num = 0
                                binding.homeViewPagerBanner.currentItem = num
                                binding.textView13.text = (num+1).toString()
                            } else {
                                binding.homeViewPagerBanner.currentItem = num+1
                                binding.textView13.text = (num+2).toString()
                            }
                        }
                    }
                }

            }

        }





        //???????????? ??????
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

        //????????? ?????? ????????????
        if(isFirst) {
            showLoadingDialog(context!!)
            HomeService(this).tryGetUsers()
        }


        //?????? ???????????? ?????????
        binding.homeImageViewCategoryAllContainer.setOnClickListener {
            startActivity(Intent(context, AllCategoryActivity::class.java))
        }


        //????????? ??????


    }

    override fun onGetItemSuccess( response: GetItemResponse) {

        recyclerItemList = ArrayList<GetItemResult>()

        Log.d("api", response.message)
       for(item in response.result){
           recyclerItemList.add(item)
       }
        recyclerAdapter = HomeRecyclerViewAdapter(context, recyclerItemList, this)
        if(binding.homeRecyclerView != null) {
            binding.homeRecyclerView.apply {
                adapter = recyclerAdapter
                layoutManager = GridLayoutManager(context, 2)
                //addItemDecoration(HomeRecyclerViewSpacing(16, 16))
            }
        }
        dismissLoadingDialog()
        //recyclerAdapter.notifyDataSetChanged()
    }

    override fun onGetItemFailure(message: String) {
        dismissLoadingDialog()
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

    override fun onStart() {
        super.onStart()
      if(!isFirst){
          showLoadingDialog(context!!)
          HomeService(this).tryGetUsers()
      }
        check = true

    }

    override fun onPause() {
        super.onPause()
      isFirst = false
        check= false
    }


}