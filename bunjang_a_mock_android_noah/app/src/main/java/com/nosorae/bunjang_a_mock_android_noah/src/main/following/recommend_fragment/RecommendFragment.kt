package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment

import android.os.Bundle
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyFeedBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentRecommendBinding

class RecommendFragment :
    BaseFragment<FragmentRecommendBinding>(FragmentRecommendBinding::bind, R.layout.fragment_recommend) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}