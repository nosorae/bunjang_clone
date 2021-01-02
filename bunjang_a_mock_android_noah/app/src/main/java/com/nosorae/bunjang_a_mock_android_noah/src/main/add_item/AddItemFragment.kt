package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item

import android.os.Bundle
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentAddItemBinding

class AddItemFragment :
    BaseFragment<FragmentAddItemBinding>(FragmentAddItemBinding::bind, R.layout.fragment_add_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}