package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentFollowingBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentInnerFollowingBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.recycler_view.CandidateRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.recycler_view.InnerRecyclerAdapter
import java.util.ArrayList


class InnerFollowingFragment :
        BaseFragment<FragmentInnerFollowingBinding>(FragmentInnerFollowingBinding::bind, R.layout.fragment_inner_following),
        InnerFollowingFragmentView {

    private var recyclerItemList = ArrayList<GetInnerResult>()
    private lateinit var recyclerAdapter : InnerRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoadingDialog(context!!)
        InnerFollowingService(this).tryGetInnerFollowing()






    }

    override fun onGetInnerSuccess(response: GetInnerResponse) {
        dismissLoadingDialog()
        recyclerItemList = response.result as ArrayList<GetInnerResult>
        recyclerAdapter = InnerRecyclerAdapter(context, recyclerItemList)
        binding.innerRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onGetInnerFailure(message: String) {

    }
}