package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyShopBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentSellingBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.recycler_view.MySellingRecyclerAdapter


class SellingFragment :
        BaseFragment<FragmentSellingBinding>(FragmentSellingBinding::bind, R.layout.fragment_selling),
        SellingFragmentView {


    private var recyclerItemList = ArrayList<GetMySellingResult>()
    private lateinit var recyclerAdapter : MySellingRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SellingService(this).tryGetSelling('Y')

    }


    override fun onGetSellingSeccess(response: GetMySellingResponse) {
       recyclerItemList = response.result as ArrayList<GetMySellingResult>
        if(recyclerItemList.size == 0) {
            binding.mySellingFragmentContainer.visibility = View.INVISIBLE
        } else {
            recyclerAdapter = MySellingRecyclerAdapter(context, recyclerItemList)
            binding.myShopSellingRecycler.apply {
                adapter = recyclerAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }


    }

    override fun onGetSellingFailure(messge: String?) {
        TODO("Not yet implemented")
    }
}