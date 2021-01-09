package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentFollowingBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentInnerFollowingBinding


class InnerFollowingFragment :
        BaseFragment<FragmentInnerFollowingBinding>(FragmentInnerFollowingBinding::bind, R.layout.fragment_inner_following) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}