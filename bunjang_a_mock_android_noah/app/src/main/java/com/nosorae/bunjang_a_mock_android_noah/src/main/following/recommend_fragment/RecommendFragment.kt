package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyFeedBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentRecommendBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model.GetRecommendResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.recycler.RecommendRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.HomeRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.view_pager.HomeViewPagerItem

class RecommendFragment :
    BaseFragment<FragmentRecommendBinding>(FragmentRecommendBinding::bind, R.layout.fragment_recommend),
        RecommendFragmentView{



    private var recyclerItemList = ArrayList<GetRecommendResult>()
    private lateinit var recyclerAdapter : RecommendRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoadingDialog(context!!)
        RecommendService(this).tryGetRecommend()




    }

    override fun onGetRecommendSuccess(response: GetRecommendResponse) {
       dismissLoadingDialog()
        Log.d("sizeOfList", "추천 항목 몇개? : "+response.result.size)
        recyclerItemList = response.result as ArrayList<GetRecommendResult>
        recyclerAdapter = RecommendRecyclerAdapter(context, recyclerItemList)
        binding.recommendRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    override fun onGetRecommendFailure(message: String) {

    }
}