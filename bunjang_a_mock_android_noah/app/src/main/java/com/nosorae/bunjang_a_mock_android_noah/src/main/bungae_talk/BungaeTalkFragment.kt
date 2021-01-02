package com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk

import android.os.Bundle
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentBungaeTalkBinding


class BungaeTalkFragment :
    BaseFragment<FragmentBungaeTalkBinding>(FragmentBungaeTalkBinding::bind, R.layout.fragment_bungae_talk) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}