package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyFeedBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.recycler.MyFeedRecyclerAdapter


class MyFeedFragment  :
    BaseFragment<FragmentMyFeedBinding>(FragmentMyFeedBinding::bind, R.layout.fragment_my_feed),
    MyFeedFragmentView {

    private var recyclerItemList = ArrayList<GetMyFeedResult>()
    private lateinit var recyclerItemRecyclerAdapter : MyFeedRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyFeedService(this).tryGetMyFeed()






    }

    override fun onGetMyFeedSuccess(response: GetMyFeedResponse) {
        recyclerItemList = response.result as ArrayList<GetMyFeedResult>
        recyclerItemRecyclerAdapter = MyFeedRecyclerAdapter(context, recyclerItemList)
        binding.myFeedRecyclerView.apply {
            adapter = recyclerItemRecyclerAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onGetMyFeedFailure(message: String) {
        TODO("Not yet implemented")
    }
}