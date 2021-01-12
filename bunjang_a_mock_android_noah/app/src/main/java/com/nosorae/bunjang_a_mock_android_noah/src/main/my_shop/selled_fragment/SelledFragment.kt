package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selled_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyShopBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentSelledBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentSellingBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.SellingFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.recycler_view.MySellingRecyclerAdapter


class SelledFragment :
        BaseFragment<FragmentSelledBinding>(FragmentSelledBinding::bind, R.layout.fragment_selled),
        SellingFragmentView
         {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     binding.mySelledContainer.visibility = View.INVISIBLE

    }


             override fun onGetSellingSeccess(response: GetMySellingResponse) {
                 TODO("Not yet implemented")
             }

             override fun onGetSellingFailure(messge: String?) {
                 TODO("Not yet implemented")
             }

             override fun onClickCheck(isOn: Int) {
                 TODO("Not yet implemented")
             }

             override fun onClickdelete(isInList: ArrayList<GetMySellingResult>) {
                 TODO("Not yet implemented")
             }
         }